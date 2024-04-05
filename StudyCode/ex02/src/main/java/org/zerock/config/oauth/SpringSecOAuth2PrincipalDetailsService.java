package org.zerock.config.oauth;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.zerock.config.auth.SpringSecPrincipalDetails;
import org.zerock.config.oauth.provider.GoogleUserInfo;
import org.zerock.config.oauth.provider.KakaoUserInfo;
import org.zerock.config.oauth.provider.NaverUserInfo;
import org.zerock.config.oauth.provider.OAuth2UserInfo;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import java.util.Date;
import java.util.Map;

@Service
public class SpringSecOAuth2PrincipalDetailsService extends DefaultOAuth2UserService {

    @Autowired
    private MemberMapper memberMapper;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("유저리퀘스트: "+userRequest);

        OAuth2User oAuth2User = super.loadUser(userRequest);

        System.out.println("getClientRegistration: " + userRequest.getClientRegistration());
        System.out.println("getAccessToken: " + userRequest.getAccessToken().getTokenValue());
        System.out.println("getAttributes: " + super.loadUser(userRequest).getAttributes());

        OAuth2UserInfo oAuth2UserInfo = null;

        System.out.println("확인"+userRequest.getClientRegistration().getRegistrationId());

        if(userRequest.getClientRegistration().getRegistrationId().equals("google")){
            System.out.println("구글 로그인 성공");
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        } else if(userRequest.getClientRegistration().getRegistrationId().equals("naver")){
            System.out.println("네이버 로그인 요청");
            oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));
        } else if(userRequest.getClientRegistration().getRegistrationId().equals("kakao")){
            System.out.println("카카오 로그인 성공");

            oAuth2UserInfo = new KakaoUserInfo(oAuth2User.getAttributes());
        } else {
            System.out.println("우리는 네이버와 구글 SNS 만 지원합니다.");
            return null;
        }


        String provider = oAuth2UserInfo.getProvider();
        String providerId = oAuth2UserInfo.getProviderId();
        String username = provider+"_"+providerId;
        String password = "-";
        String email = oAuth2UserInfo.getEmail();
        String role = "ROLE_USER";


        // 실제 회원가입된 유저인지 확인
        MemberVO memberVO = memberMapper.selectByUserName(username);
        if (memberVO == null) {       // OAuth2로 회원가입이 안된 경우
            // 회원가입 시도
            memberVO = MemberVO.builder()
                    .korName("-")
                    .provider(provider)
                    .providerId(providerId)
                    .username(username)
                    .password(password)
                    .email(email)
                    .role(role)
                    .build();
            System.out.println(memberVO);
            memberMapper.insertMember(memberVO);
        } else {                      // OAuth2로 회원가입이 된 경우

        }

        return new SpringSecPrincipalDetails(memberVO, oAuth2User.getAttributes());
    }
}
