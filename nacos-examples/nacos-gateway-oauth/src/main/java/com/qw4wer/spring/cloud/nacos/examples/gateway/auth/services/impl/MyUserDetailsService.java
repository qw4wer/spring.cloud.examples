package com.qw4wer.spring.cloud.nacos.examples.gateway.auth.services.impl;

import com.qw4wer.spring.cloud.nacos.examples.common.RestResult;
import com.qw4wer.spring.cloud.nacos.examples.common.data.dto.SysUserDto;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysPermission;
import com.qw4wer.spring.cloud.nacos.examples.gateway.auth.pojo.User;
import com.qw4wer.spring.cloud.nacos.examples.gateway.auth.provider.AuthProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MyUserDetailsService implements ReactiveUserDetailsService {
    @Autowired
    AuthProvider authProvider;


    @Override
    public Mono<UserDetails> findByUsername(String username) {
        log.info(username);
        RestResult<SysUserDto> userByUniqueId = authProvider.getUserByUniqueId(username);

        if (userByUniqueId.getCode() != 200) {
//            return Mono.error(new RuntimeException(userByUniqueId.getMessage()));
            throw new ProviderNotFoundException(userByUniqueId.getMessage());
        }
        SysUserDto sysUserDto = userByUniqueId.getData();
        if (sysUserDto == null) {
            throw new UsernameNotFoundException("用户未找到");
        }

        Set<String> collect = sysUserDto.getSysPermissionList().stream().map(SysPermission::getUrl).collect(Collectors.toSet());
        User user = User.builder().id(sysUserDto.getId()).username(sysUserDto.getUserName()).password(sysUserDto.getPassword()).apiResourceUrlSet(collect).build();
        return Mono.just(user);
    }
}