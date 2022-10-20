package com.example.test1.controller;

import com.example.test1.service.TestService;
import com.example.test1.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String test1() {
        int i = 0;
        Constant.b.put("a", 0);
        while (i < 20) {
            i++;
            testService.asyncTest();
            System.out.println("\"a\" = " + "a");
        }
        return null;
    }
}
