package com.example.test1.controller;

import com.example.test1.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author : panzhenye
 * @date : 2022/9/7 18:14
 */
@RestController
@Slf4j
public class TestController {


    @Autowired
    private TestService testService;

    @RequestMapping("test1")
    public String test1() throws Exception {
        Future<String> stringFuture = testService.asyncTest();
        log.info("模拟业务2");
        TimeUnit.SECONDS.sleep(2);
        String s = stringFuture.get();
        log.info("模拟业务3");
        return s;
    }

    public String test2() throws Exception {
        String stringFuture = testService.asyncTest2();
        log.info("模拟业务2");
        TimeUnit.SECONDS.sleep(2);
        String s = stringFuture;
        return s;
    }

    public String test3() throws Exception {
        testService.asyncTestException();
        return "s";
    }
}
