package com.qw4wer.spring.cloud.nacos.examples.gateway.auth.config;

import com.qw4wer.spring.cloud.nacos.examples.gateway.auth.enums.ServerCodeEnum;
import com.qw4wer.spring.cloud.nacos.examples.gateway.auth.security.AuthenticationConverter;
import com.qw4wer.spring.cloud.nacos.examples.gateway.auth.security.AuthorizeConfigManager;
import com.qw4wer.spring.cloud.nacos.examples.gateway.auth.utils.ResponseUtils;
import com.qw4wer.spring.cloud.nacos.examples.gateway.auth.utils.RestResult;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authentication.DelegatingReactiveAuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;

import java.util.LinkedList;

@Configuration
@EnableWebFluxSecurity
@CommonsLog
public class SecurityConfig {

    @Autowired
    private AuthenticationConverter authenticationConverter;

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

//    @Autowired
//    private AuthEntryPointException serverAuthenticationEntryPoint;
//
//    @Autowired
//    private JsonServerAuthenticationSuccessHandler jsonServerAuthenticationSuccessHandler;
//
//    @Autowired
//    private JsonServerAuthenticationFailureHandler jsonServerAuthenticationFailureHandler;

    @Autowired
    private ReactiveAuthenticationManager authenticationManager;

    private static final String[] AUTH_WHITELIST = new String[]{"/login", "/logout"};

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        SecurityWebFilterChain chain = http.formLogin()
                .loginPage("/login")
                // ????????????handler
                .authenticationSuccessHandler(jsonServerAuthenticationSuccessHandler())
                // ????????????handler
                .authenticationFailureHandler(jsonServerAuthenticationFailureHandler())
                // ???????????????handler
                .authenticationEntryPoint(authenticationEntryPoint())
                .and()
                .logout()
                // ????????????handler
                .logoutSuccessHandler(serverLogoutSuccessHandler())
                .and()
                .csrf().disable()
                .httpBasic().disable()
                .authorizeExchange()
                // ???????????????
                .pathMatchers(AUTH_WHITELIST).permitAll()
                // ??????????????????
                .anyExchange().access(authorizeConfigManager)
                .and().exceptionHandling().authenticationEntryPoint(serverAuthenticationEntryPoint()).accessDeniedHandler(serverAccessDeniedHandler())
                .and().build();
        // ????????????????????????????????????
        chain.getWebFilters()
                .filter(webFilter -> webFilter instanceof AuthenticationWebFilter)
                .subscribe(webFilter -> {
                    AuthenticationWebFilter filter = (AuthenticationWebFilter) webFilter;
                    filter.setServerAuthenticationConverter(authenticationConverter);
                });
        return chain;
    }

    /**
     * ?????????????????????????????????????????????????????????
     *
     * @return
     */
    @Bean
    public ServerAuthenticationEntryPoint authenticationEntryPoint() {
        ServerAuthenticationEntryPoint entryPoint = (exchange, ex) -> {
            RestResult restResult = RestResult.error(ServerCodeEnum.NOT_LOGIN.getCode(), ServerCodeEnum.NOT_LOGIN.getMemo());
            return ResponseUtils.write(exchange.getResponse(), restResult);
        };
        return entryPoint;
    }

    @Bean
    public ServerAuthenticationSuccessHandler jsonServerAuthenticationSuccessHandler() {
        ServerAuthenticationSuccessHandler entryPoint = (webFilterExchange, authentication) -> {
            RestResult restResult = RestResult.success("????????????", null);
            return ResponseUtils.write(webFilterExchange.getExchange().getResponse(), restResult);
        };
        return entryPoint;
    }

    @Bean
    public ServerAuthenticationFailureHandler jsonServerAuthenticationFailureHandler() {
        ServerAuthenticationFailureHandler entryPoint = (webFilterExchange, authentication) -> {
            RestResult restResult = RestResult.error(500,authentication.getMessage());
            return ResponseUtils.write(webFilterExchange.getExchange().getResponse(), restResult);
        };
        return entryPoint;
    }

    @Bean
    public ServerLogoutSuccessHandler serverLogoutSuccessHandler() {
        ServerLogoutSuccessHandler entryPoint = (webFilterExchange, authentication) -> {
            ServerHttpResponse response = webFilterExchange.getExchange().getResponse();
            RestResult restResult = RestResult.success("????????????", new Object());
            return ResponseUtils.write(response, restResult);
        };
        return entryPoint;
    }

    @Bean
    public ServerAccessDeniedHandler serverAccessDeniedHandler() {
        return (exchange, denied) -> {
            ServerHttpResponse response = exchange.getResponse();
            RestResult restResult = RestResult.error(ServerCodeEnum.NOT_AUTHORITY);
            return ResponseUtils.write(response, restResult);
        };
    }


    /**
     * ???????????????????????????????????????????????????????????????????????????
     *
     * @return
     */
    @Bean
    ReactiveAuthenticationManager reactiveAuthenticationManager() {
        LinkedList<ReactiveAuthenticationManager> managers = new LinkedList<>();
        managers.add(authenticationManager);
        return new DelegatingReactiveAuthenticationManager(managers);
    }

    @Bean
    ServerAuthenticationEntryPoint serverAuthenticationEntryPoint() {
        return (exchange, ex) -> {
            ServerHttpResponse response = exchange.getResponse();
            RestResult restResult = RestResult.error(ServerCodeEnum.NOT_AUTHORITY);
            return ResponseUtils.write(response, restResult);
        };
    }


    /**
     * BCrypt????????????
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}