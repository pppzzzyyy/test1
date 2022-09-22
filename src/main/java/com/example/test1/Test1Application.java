package com.example.test1;

import com.example.test1.controller.TestController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author : panzhenye
 * @date : 2022/9/7 18:14
 */
@SpringBootApplication
@MapperScan(basePackages = "com.example.test1.mapper")
public class Test1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Test1Application.class, args);
        TestController testController = run.getBean("testController", TestController.class);
        testController.test2();


    }

}
