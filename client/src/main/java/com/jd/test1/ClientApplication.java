package com.jd.test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author : panzhenye
 * @date : 2022/9/23 15:20
 */
@SpringBootApplication
@EnableFeignClients
public class ClientApplication {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(ClientApplication.class, args);
        JdUserServiceImpl bean = run.getBean(JdUserServiceImpl.class);
        bean.test();

    }
}
