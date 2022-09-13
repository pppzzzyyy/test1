package com.example.test1;

import com.example.test1.entity.JdUser;
import com.example.test1.mapper.JdUserMapper;
import com.example.test1.service.JdUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * @author : panzhenye
 * @date : 2022/9/7 18:14
 */
@SpringBootApplication
@MapperScan(basePackages = "com.example.test1.mapper")
public class Test1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Test1Application.class, args);
        JdUserService jdUserService = run.getBean("jdUserServiceImpl", JdUserService.class);
        List<JdUser> list = jdUserService.list();
        System.out.println("list = " + list);
        JdUser jdUser = new JdUser();
        jdUser.setJdUserId("10");
        jdUser.setJdUserName("1");
        JdUserMapper bean = run.getBean(JdUserMapper.class);
        int i = bean.updateById(jdUser);
        System.out.println("i = " + i);

    }

}
