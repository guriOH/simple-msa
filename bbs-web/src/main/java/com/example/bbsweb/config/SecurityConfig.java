package com.example.bbsweb.config;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder encodePassword() {  // 회원가입 시 비밀번호 암호화에 사용할 Encoder 빈 등록
        return new BCryptPasswordEncoder();
    }



    private static final String[] PERMIT_API = {
            "/",
            "/auth/**"
    };
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/anonymous*").anonymous()
                .requestMatchers(PERMIT_API).permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/loginPage")
                    .defaultSuccessUrl("/")
                    .failureUrl("/login")
                    .successHandler(new AuthenticationSuccessHandler() {
                        @Override
                        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                            System.out.println("authentication : " + authentication.getName());
                            response.sendRedirect("/");
                        }
                    })
                    .failureHandler(new AuthenticationFailureHandler() {
                        @Override
                        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                            System.out.println("exception : " + exception.getMessage());
                            response.sendRedirect("/login");
                        }
                    })
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
        return http.build();

    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/common/**",    //커스텀 리소스
                "/lib/**",
                "/assets/**",   //Bootstrap 리소스
                "/landing/**",  //랜딩관련
                "/favicon.png", //아이콘
                "/error", //에러페이지
                // Swagger 관련 리소스
                "/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html", "/webjars/**",
                "/swagger/**", "/image/**",
                "/sign-up");
    }
}
