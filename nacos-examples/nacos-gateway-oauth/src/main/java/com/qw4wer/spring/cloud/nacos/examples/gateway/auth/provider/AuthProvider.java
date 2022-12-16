package com.qw4wer.spring.cloud.nacos.examples.gateway.auth.provider;

import com.qw4wer.spring.cloud.nacos.examples.common.RestResult;
import com.qw4wer.spring.cloud.nacos.examples.common.data.dto.SysUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "nacos-provider",fallback = AuthProviderFallback.class)
public interface AuthProvider {

    @GetMapping(value = "/user/login")
    RestResult<SysUserDto> getUserByUniqueId(@RequestParam("username") String username);


}
