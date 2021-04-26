package com.qw4wer.spring.cloud.nacos.examples.gateway.auth.utils;

import io.netty.util.CharsetUtil;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

public class ResponseUtils {

    public static Mono<Void> write(ServerHttpResponse response, Object o) {
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        String s = JsonUtils.toJson(o);
        DataBuffer buffer = response.bufferFactory().wrap(s.getBytes(CharsetUtil.UTF_8));
        return response.writeWith(Mono.just(buffer));
    }
}
