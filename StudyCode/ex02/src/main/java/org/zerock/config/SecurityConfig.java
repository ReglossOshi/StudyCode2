package org.zerock.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.zerock.config.oauth.SpringSecOAuth2PrincipalDetailsService;

//@EnableWebSecurity  //웹 보안 활성화를 위한 어노테이션
//@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
@Configuration //스프링 빈에 등록
@EnableMethodSecurity(securedEnabled = true)   //PreAuthorize, ProAuthorize 어노테이션 사용해주는 어노테이션
public class SecurityConfig {

    @Autowired
    private SpringSecOAuth2PrincipalDetailsService oAuth2PrincipalDetailsService;


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // method chainning으로 security 설정
//        ((formLogin) -> formLogin.loginPage(""))
        http.csrf().disable()
                .authorizeRequests((authorizeHttpRequests)->authorizeHttpRequests
//                                        .requestMatchers(new AntPathRequestMatcher("/board/**")).authenticated() // /board로 시작하는 url은 인증을 받아야 함
//                                        .requestMatchers(new AntPathRequestMatcher("/reply/**")).authenticated() // /reply로 시작하는 url은 인증을 받아야 함
//                                        .requestMatchers(HttpMethod.GET,"/board/**").authenticated() // /board로 시작하는 url은 인증을 받아야 함
//                                        .requestMatchers(new AntPathRequestMatcher("/join")).permitAll()
//                                        .requestMatchers(new AntPathRequestMatcher("/joinProc")).permitAll()
//                                        .requestMatchers(new AntPathRequestMatcher("/login")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/board/**","POST"),new AntPathRequestMatcher("/replies/**")).authenticated() // /board로 시작하는 url은 인증을 받아야 함
                                        .requestMatchers(new AntPathRequestMatcher("//**")).authenticated()
                                        .requestMatchers(new AntPathRequestMatcher("/admin/**"))//.access("hasRole('ROLE_ADMIN')")
                                                .hasRole("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/manager/**"))//.access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                                                .hasAnyRole("MANAGER","ADMIN")
                                        .anyRequest().permitAll()
                ) // /로 시작하는 url은 인증을 받아야함
//            .formLogin()                        //form 로그인 사용
//            .loginPage("/login")                //form 로그인 페이지 url 설정
//            .defaultSuccessUrl("/")         //form 로그인 성공시 이동해야 할 url
//            .failureUrl("/login-failure")
//            .and()
//            .authorizeHttpRequests().requestMatchers("/board/**", "/replies/**").authenticated()
//            .anyRequest().permitAll()
//            .and() 스프링 시큐리티 3.2부터 가능
            .formLogin((formLogin) ->
                        formLogin.loginPage("/login")
                                .defaultSuccessUrl("/")
                                .failureUrl("/login-failure")
            )

            .logout()                       //form 로그아웃
            .logoutSuccessUrl("/login")     //form 로그아웃 성공시 이동해야 할 url
            .invalidateHttpSession(true)    //로그아웃 본인 계정 session 초기화
                .and()
                .oauth2Login()
                    .loginPage("/login") //session을 받는 후처리 필요
                .userInfoEndpoint().userService(oAuth2PrincipalDetailsService)   //구글의 엑세스 토큰 및 사용자 정보 처리하는 서비스 등록
            // 토큰 위조 공격 방어 사용안함
        ;
            // 구글 로그인이 완료된 뒤의 후처리 필요 1.코드받기(인증) 2.엑세스토큰(권한) 3.사용자 프로필 정보 가져옴 4.정보를 토대로 회원가입 자동 진행
            // 4-2. 정보가 / Tip. 코드 X (엑세스토큰+사용자프로필정보 O)
        return http.build();
    }

    public void configure(WebSecurity web) throws Exception{
        web.httpFirewall(defaultHttpFirewall());
    }
    @Bean
    public HttpFirewall defaultHttpFirewall(){
        return new DefaultHttpFirewall();
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
