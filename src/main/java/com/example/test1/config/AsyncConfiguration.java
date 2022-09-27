package com.example.test1.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author pzy
 * @version 1.0
 * @Description Async 异步注解线程配置, AsyncConfigurer 默认配置实现,默认的线程池 SimpleAsyncTaskExecutor
 * @date 2022/8/19 11:05
 */
@Configuration
@EnableAsync
public class AsyncConfiguration implements AsyncConfigurer {

    private static final Logger LOGGER = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    //线程池配置
    @Bean(name = "asyncPoolTaskExecutor")
    public ThreadPoolTaskExecutor executor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        /*
        程序每秒需要处理的最大任务数量
        tasks = 100
        单线程处理一个任务所需要的时间
        tasktime = 1/4s
        系统允许任务最大的响应时间
        responsetime = 10s

        cordPoolSize = tasks*tasktime = 25
        当每秒达到3000个任务时
        maxPoolSize = (3000-queueCapacity)*tasktime = 500
        queueCapacity = (corePoolSize/tasktime)responsetime = tasks*responsetime = 1000
        */
        //核销线程数
        taskExecutor.setCorePoolSize(25);
        //线程池维护线程的最大数量,只有在缓冲队列满了之后才会申请超过核心线程数的线程
        taskExecutor.setMaxPoolSize(500);
        //缓存队列
        taskExecutor.setQueueCapacity(1000);
        //允许的空闲时间,当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
        taskExecutor.setKeepAliveSeconds(60);
        //异步方法内部线程名称
        taskExecutor.setThreadNamePrefix("async-");
        /**
         * 当线程池的任务缓存队列已满并且线程池中的线程数目达到maximumPoolSize，如果还有任务到来就会采取任务拒绝策略
         * 通常有以下四种策略：
         * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
         * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
         * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
         * ThreadPoolExecutor.CallerRunsPolicy：重试添加当前的任务，自动重复调用 execute() 方法，直到成功
         */
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();

        return taskExecutor;

    }

    //线程池配置
    @Bean(name = "asyncPoolTaskExecutor1")
    public ThreadPoolTaskExecutor executor1() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        /*
        程序每秒需要处理的最大任务数量
        tasks = 100
        单线程处理一个任务所需要的时间
        tasktime = 1/4s
        系统允许任务最大的响应时间
        responsetime = 10s

        cordPoolSize = tasks*tasktime = 25
        当每秒达到3000个任务时
        maxPoolSize = (3000-queueCapacity)*tasktime = 500
        queueCapacity = (corePoolSize/tasktime)responsetime = tasks*responsetime = 1000
        */
        //核销线程数
        taskExecutor.setCorePoolSize(25);
        //线程池维护线程的最大数量,只有在缓冲队列满了之后才会申请超过核心线程数的线程
        taskExecutor.setMaxPoolSize(500);
        //缓存队列
        taskExecutor.setQueueCapacity(1000);
        //允许的空闲时间,当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
        taskExecutor.setKeepAliveSeconds(60);
        //异步方法内部线程名称
        taskExecutor.setThreadNamePrefix("async1-");
        /**
         * 当线程池的任务缓存队列已满并且线程池中的线程数目达到maximumPoolSize，如果还有任务到来就会采取任务拒绝策略
         * 通常有以下四种策略：
         * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
         * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
         * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
         * ThreadPoolExecutor.CallerRunsPolicy：重试添加当前的任务，自动重复调用 execute() 方法，直到成功
         */
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();

        return taskExecutor;

    }


    //指定默认线程池
    @Override
    public Executor getAsyncExecutor() {
        return executor();
    }

    //线程异常处理
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {

        return (ex, method, params) ->
                LOGGER.error("线程池执行任务发送未知错误,执行方法：{}", method.getName(), ex);
    }
}