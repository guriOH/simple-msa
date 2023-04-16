package com.example.bbsweb.config;


import com.example.bbsweb.config.filter.CustomAuthenticationManager;
import com.example.bbsweb.config.filter.CustomAuthenticationProcessingFilter;
import com.example.bbsweb.config.filter.UserDetailServiceImpl;
import com.example.bbsweb.config.handler.CustomAuthenticationFailureHandler;
import com.example.bbsweb.config.handler.CustomAuthenticationSuccessHandler;
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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final String[] PERMIT_API = {
            "/**",
            "/auth/**",
            "/bbs/**"
    };

    @Bean
    public BCryptPasswordEncoder encodePassword() {  // 회원가입 시 비밀번호 암호화에 사용할 Encoder 빈 등록
        return new BCryptPasswordEncoder();
    }



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
                .and()
                    .addFilterBefore(customAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }

    // 커스텀 인증 필터
    @Bean
    public CustomAuthenticationProcessingFilter customAuthenticationProcessingFilter() {
        CustomAuthenticationProcessingFilter filter = new CustomAuthenticationProcessingFilter("/auth/login");
        filter.setAuthenticationManager(customAuthenticationManager());
        filter.setAuthenticationFailureHandler(new CustomAuthenticationFailureHandler("/login"));
        filter.setAuthenticationSuccessHandler(new CustomAuthenticationSuccessHandler("/"));
        return filter;
    }

    // 커스텀 인증 매니저
    @Bean
    public CustomAuthenticationManager customAuthenticationManager() {
        return new CustomAuthenticationManager();
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
