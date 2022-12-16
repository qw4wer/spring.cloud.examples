package com.qw4wer.spring.cloud.nacos.examples.gateway.auth.provider;

import com.qw4wer.spring.cloud.nacos.examples.common.RestResult;
import com.qw4wer.spring.cloud.nacos.examples.common.data.dto.SysUserDto;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2

public class AuthProviderFallback implements AuthProvider{


    @Override
    public RestResult<SysUserDto> getUserByUniqueId(String uniqueId) {
        log.error(uniqueId);
        return RestResult.error("network");
    }
}
