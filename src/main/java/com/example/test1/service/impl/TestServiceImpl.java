package com.example.test1.service.impl;

import com.example.test1.service.TestService;
import com.example.test1.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;

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

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    @Async
    public void asyncTest() {
        while (!redisTemplate.opsForValue().setIfAbsent("a","a", Duration.ofSeconds(1))) {
            log.info(Thread.currentThread().getName() + "没拿到锁");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info(Thread.currentThread().getName() + "拿到锁");
        if (Constant.b.get("a") <= 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Constant.b.computeIfPresent("a", (key, value) -> value + 100);
        } else {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Constant.b.computeIfPresent("a", (key, value) -> value - 100);
        }
//            if (true) {
//                throw new RuntimeException("2");
//            }
        log.info("inta = " + Constant.b.get("a"));
        redisTemplate.delete("a");
    }

}
