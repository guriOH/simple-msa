package com.example.bbsadmin.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .defaultSuccessUrl("/")
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
                "/swagger/**", "/image/**");
    }
}
