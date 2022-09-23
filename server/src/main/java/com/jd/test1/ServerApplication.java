package com.jd.test1;

import com.jd.jsf.spring.boot.annotation.EnableJsf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * @author : panzhenye
 * @date : 2022/9/23 15:20
 */
@SpringBootApplication
@EnableJsf
@ImportResource(locations = {"classpath:*.xml"})
public class ServerApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ServerApplication.class, args);
    }
}
