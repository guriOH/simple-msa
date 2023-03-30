package com.example.bbsweb.config.filter;

import com.example.bbscore.domain.auth.persistence.entity.User;
import com.example.bbscore.domain.auth.persistence.repository.UserRepository;
import com.example.bbscore.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = authService.findUserByEmailAddress(email);
        return new CustomUserDetails(user);
    }
}
