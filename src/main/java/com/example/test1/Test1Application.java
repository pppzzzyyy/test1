package com.example.test1;

import com.example.test1.controller.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author : panzhenye
 * @date : 2022/9/7 18:14
 */
@SpringBootApplication
@EnableAsync
public class Test1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Test1Application.class, args);
        TestController testController = (TestController) run.getBean("testController");
        testController.test1();
    }

}
