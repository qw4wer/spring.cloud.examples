package com.qw4wer.spring.cloud.nacos.examples.gateway.auth;

import org.junit.jupiter.api.Test;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class TestMono {

    @Test
    public void t1() {
        Mono.empty().subscribe(System.out::println);
        Mono.just("foo").subscribe(System.out::println);
        Mono.create(sink -> sink.success("create MonoSink")).subscribe(System.out::println);

        long loadstart = System.currentTimeMillis();
        Disposable disposable = Mono.delay(Duration.ofSeconds(3)).subscribe(n -> {
            System.out.println("生产数据源："+ n);
            System.out.println("当前线程ID："+ Thread.currentThread().getId() + ",生产到消费耗时："+ (System.currentTimeMillis() - loadstart));
        });
        System.out.println("主线程"+ Thread.currentThread().getId() + "耗时："+ (System.currentTimeMillis() - loadstart));
        while(!disposable.isDisposed()) {
        }
    }

}
