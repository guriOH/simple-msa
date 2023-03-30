package com.example.bbsweb.config.filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import java.io.IOException;

public class CustomAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    public CustomAuthenticationProcessingFilter(String defaultFilterProcessesUrl) {
        // defaultFilterProcessesUrl로 설정한 URL이 호출되면 수행한다
        super(defaultFilterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // username, password를 받아 UsernamePasswordAuthenticationToken 담아 실제 인증처리를 하는 매니저를 호출
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(email, password));
    }
}
