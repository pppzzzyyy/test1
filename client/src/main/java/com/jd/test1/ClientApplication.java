package com.jd.test1;

import com.jd.jsf.spring.boot.annotation.EnableJsf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.TimeUnit;

/**
 * @author : panzhenye
 * @date : 2022/9/23 15:20
 */
@SpringBootApplication
@EnableJsf
@ImportResource(locations = {"classpath:*.xml"})
public class ClientApplication {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(ClientApplication.class, args);
        Consumer1 bean = run.getBean(Consumer1.class);
        while (true) {
            TimeUnit.SECONDS.sleep(1L);
            bean.test("123");
        }
    }
}
