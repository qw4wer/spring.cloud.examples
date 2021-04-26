package com.qw4wer.spring.cloud.nacos.examples.gateway.auth.services;

import com.qw4wer.spring.cloud.nacos.examples.gateway.auth.pojo.User;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashSet;

@Service
@CommonsLog
public class MyUserDetailsService implements ReactiveUserDetailsService {

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        log.info(username);
        HashSet<String> set = new HashSet<>();
        set.add("/t1");
        set.add("/test");
        return Mono.just(new User(1, username, new BCryptPasswordEncoder().encode("pwd"), set));
    }
}