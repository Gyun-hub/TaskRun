package com.dev.taskrun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    // 커스텀 쓰레드풀 설정
    @Bean(name = "customExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);       // 기본 쓰레드 수
        executor.setMaxPoolSize(10);       // 최대 쓰레드 수
        executor.setQueueCapacity(100);    // 큐 사이즈
        executor.setThreadNamePrefix("Async-");
        executor.initialize();
        return executor;
    }
}
