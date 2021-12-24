package com.qw4wer.spring.cloud.nacos.examples.gateway.auth.provider;

import com.qw4wer.spring.cloud.nacos.examples.common.RestResult;
import com.qw4wer.spring.cloud.nacos.examples.common.data.dto.SysUserDto;
import org.springframework.stereotype.Component;

@Component
public class AuthProviderFallback implements AuthProvider{


    @Override
    public RestResult<SysUserDto> getUserByUniqueId(String uniqueId) {
        return null;
    }
}
