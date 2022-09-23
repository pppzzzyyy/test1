package com.jd.test1;

import com.jd.jsf.spring.boot.annotation.EnableJsf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author : panzhenye
 * @date : 2022/9/23 15:20
 */
@SpringBootApplication
@EnableJsf
public class ClientApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ClientApplication.class, args);
        Consumer1 bean = run.getBean(Consumer1.class);
        while (true) {
            bean.test("123");
        }
    }
}
