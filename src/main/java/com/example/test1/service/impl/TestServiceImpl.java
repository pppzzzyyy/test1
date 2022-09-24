package com.example.test1.service.impl;

import com.example.test1.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author : panzhenye
 * @date : 2022/9/7 18:14
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {
    public static int a = 0;
    public static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//    public static HashMap<String,String> map = new HashMap<>();


    @Override
    @Async
    public Future<String> asyncTest() throws InterruptedException {
        log.info("模拟业务");
        TimeUnit.SECONDS.sleep(2);
        return new AsyncResult<>("success");
    }

    @Override
    public String asyncTest2() throws InterruptedException {
        log.info("模拟业务");
        TimeUnit.SECONDS.sleep(2);
        return "success";
    }
}
