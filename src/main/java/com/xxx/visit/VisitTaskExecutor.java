package com.xxx.visit;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

@Component
class VisitTaskExecutor extends ThreadPoolTaskExecutor {
    VisitTaskExecutor() {
        setCorePoolSize(1);
        setMaxPoolSize(6);
        setQueueCapacity(32);
        setKeepAliveSeconds(60);
        setThreadNamePrefix(getClass().getSimpleName());
        setWaitForTasksToCompleteOnShutdown(true);
        setAwaitTerminationSeconds(10);
        setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 执行初始化
        initialize();
    }
}
