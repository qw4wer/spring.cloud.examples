package com.qw4wer.spring.cloud.simple.examples.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DelegatingReactiveAuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.LinkedList;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    final ReactiveAuthenticationManager authenticationManager;

    public SecurityConfig(ReactiveAuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {


        http
                .csrf().disable()
                .authorizeExchange()

                .pathMatchers("/swagger-ui.html").hasRole("ADMIN")

                .anyExchange()
                .authenticated()
                .and()
                .formLogin()

        ;

        return http.build();
    }

    @Bean
    ReactiveAuthenticationManager reactiveAuthenticationManager() {
        LinkedList<ReactiveAuthenticationManager> managers = new LinkedList<>();
        managers.add(authenticationManager);
        return new DelegatingReactiveAuthenticationManager(managers);
    }
}