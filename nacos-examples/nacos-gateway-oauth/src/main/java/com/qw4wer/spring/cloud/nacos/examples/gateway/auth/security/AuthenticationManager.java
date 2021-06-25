package com.qw4wer.spring.cloud.nacos.examples.gateway.auth.security;

import com.qw4wer.spring.cloud.nacos.examples.gateway.auth.services.MyUserDetailsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractUserDetailsReactiveAuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Component
public class AuthenticationManager extends AbstractUserDetailsReactiveAuthenticationManager {

    private Scheduler scheduler = Schedulers.boundedElastic();

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        AuthenticationToken token = (AuthenticationToken) authentication;
        final String username = authentication.getName();
        final String presentedPassword = (String) authentication.getCredentials();
        final String tenant = token.getTenant();
        final String host = token.getHost();

        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(presentedPassword))
            return Mono.error(new BadCredentialsException("username or password is null"));
        return retrieveUser(username)
                .publishOn(scheduler)
                .filter(u -> passwordEncoder.matches(presentedPassword, u.getPassword()))
                .switchIfEmpty(Mono.defer(() -> Mono.error(new BadCredentialsException("Invalid Credentials"))))
                .flatMap(userDetails -> Mono.just(userDetails))
                .map(u -> new AuthenticationToken(u, u.getPassword(), u.getAuthorities()));
    }

    @Override
    protected Mono<UserDetails> retrieveUser(String username) {
        return myUserDetailsService.findByUsername(username);
    }
}