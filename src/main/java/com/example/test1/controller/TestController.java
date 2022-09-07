package com.example.test1.controller;

import com.example.test1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : panzhenye
 * @date : 2022/9/7 18:14
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;
}
