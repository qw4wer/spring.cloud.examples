package com.qw4wer.spring.cloud.oauth.security;

import com.qw4wer.spring.cloud.oauth.pojo.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
@Log
public class WebAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    private UserDetailsService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User userDto = (User) userService.loadUserByUsername(authentication.getName());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = (String) authentication.getCredentials();
        if (!encoder.matches(password, userDto.getPassword())) {
            throw new BadCredentialsException("用户名或密码错误");
        }
        if (!CollectionUtils.isEmpty(userDto.getApiResourceUrlSet())) {
            Collection<? extends GrantedAuthority> authorities = userDto.getApiResourceUrlSet().stream().map(item -> new SimpleGrantedAuthority(item)).collect(Collectors.toList());
            return new UsernamePasswordAuthenticationToken(userDto, userDto.getPassword(), authorities);
        }
        return new UsernamePasswordAuthenticationToken(userDto, userDto.getPassword(), null);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}