package com.example.test1.service;

import com.example.test1.entity.JdUser;
import org.springframework.scheduling.annotation.Async;

/**
 * @author : panzhenye
 * @date : 2022/9/7 18:14
 */
public interface TestService {
    void test4(JdUser jdUser) throws InterruptedException;

    @Async
    void test41(JdUser jdUser) throws InterruptedException;
}
