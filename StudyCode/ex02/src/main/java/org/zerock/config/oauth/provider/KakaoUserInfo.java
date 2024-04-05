package org.zerock.config.oauth.provider;

import java.util.Map;

public class KakaoUserInfo implements OAuth2UserInfo{

    private Map<String, Object> attrs;
    private Map<String, Object> attrsAccount;
    private Map<String, Object> attrsProfile;
    public KakaoUserInfo(Map<String, Object> attrs) {
        this.attrs=attrs;
        this.attrsAccount = (Map<String, Object>) attrs.get("kakao_account");
        this.attrsProfile = (Map<String, Object>) attrsAccount.get("profile");
    }

    @Override
    public String getProviderId() {
        return attrs.get("id").toString();
    }

    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getEmail() {
        return attrsAccount.get("email").toString();
    }

    @Override
    public String getName() {
        return attrsProfile.get("nickname").toString();
    }
}
