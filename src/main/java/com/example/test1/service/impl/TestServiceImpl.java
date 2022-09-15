package com.example.test1.service.impl;

import com.example.test1.service.TestService;
import com.example.test1.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author : panzhenye
 * @date : 2022/9/7 18:14
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {
    public static int a = 0;

    @Override
    @Async
    public void asyncTest() {
        log.info("inta = " + Constant.b.get("a"));
        synchronized (this) {
            if (Constant.b.get("a") <= 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Constant.b.computeIfPresent("a",(key,value)->value+100);
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Constant.b.computeIfPresent("a",(key,value)->value-100);
            }
        }
//        log.info("inta = " + Constant.b.get("a"));
    }

}
