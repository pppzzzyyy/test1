package com.example.test1.service;

import java.util.concurrent.Future;

/**
 * @author : panzhenye
 * @date : 2022/9/7 18:14
 */
public interface TestService {
    Future<String> asyncTest() throws InterruptedException;

    String asyncTest2() throws InterruptedException;

    void asyncTestException() throws InterruptedException;
}
