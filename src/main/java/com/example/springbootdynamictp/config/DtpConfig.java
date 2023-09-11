package com.example.springbootdynamictp.config;

import org.dromara.dynamictp.common.em.QueueTypeEnum;
import org.dromara.dynamictp.core.support.DynamicTp;
import org.dromara.dynamictp.core.support.ThreadPoolBuilder;
import org.dromara.dynamictp.core.support.ThreadPoolCreator;
import org.dromara.dynamictp.core.thread.DtpExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Mr.Tong
 */
@Configuration
public class DtpConfig {


    @DynamicTp("localDtpTest1")
    @Bean
    public ThreadPoolExecutor commonExecutor() {
        return (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
    }

    @Bean
    public DtpExecutor simpleExecutor() {
        return ThreadPoolCreator.createDynamicFast("localDtpTest2");
    }

    @Bean
    public DtpExecutor ioIntensiveExecutor() {
        return ThreadPoolBuilder.newBuilder()
                .threadPoolName("localDtpTest3")
                .corePoolSize(20)
                .maximumPoolSize(50)
                .queueCapacity(2048)
                .ioIntensive(true)
                .buildDynamic();
    }

    @Bean
    public ThreadPoolExecutor buildExecutor() {
        return ThreadPoolBuilder.newBuilder()
                .threadPoolName("localDtpTest4")
                .corePoolSize(10)
                .maximumPoolSize(15)
                .keepAliveTime(50)
                .timeUnit(TimeUnit.MILLISECONDS)
                .workQueue(QueueTypeEnum.SYNCHRONOUS_QUEUE.getName(), null, false)
                .waitForTasksToCompleteOnShutdown(true)
                .awaitTerminationSeconds(5)
                .buildDynamic();
    }
}

