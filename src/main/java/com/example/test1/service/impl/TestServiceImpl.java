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
        Integer inta = Constant.b.get("a");
        log.info("inta = " + inta);
        if (inta <= 0) {
            Constant.b.put("a", Constant.b.get("a") + 100);
        } else {
            Constant.b.put("a", Constant.b.get("a") - 100);
        }
    }

}
