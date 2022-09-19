package com.example.test1;

import com.example.test1.entity.JdUser;
import com.example.test1.mapper.JdUserMapper;
import com.example.test1.service.JdUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author : panzhenye
 * @date : 2022/9/7 18:14
 */
@SpringBootApplication
@MapperScan(basePackages = "com.example.test1.mapper")
@EnableCaching
public class Test1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Test1Application.class, args);
        JdUserService jdUserService = run.getBean("jdUserServiceImpl", JdUserService.class);
//        List<JdUser> list = jdUserService.list();
//        System.out.println("list = " + list);
        JdUser byId = jdUserService.getById("1");
        System.out.println("byId = " + byId);
        JdUser jdUser = new JdUser();
        jdUser.setJdUserId("2");
        jdUser.setJdUserName("1");
        jdUserService.myUpdateById(jdUser);
        byId = jdUserService.getById("1");
        System.out.println("byId = " + byId);
        jdUser = new JdUser();
        jdUser.setJdUserId("1");
        jdUser.setJdUserName("1");
        jdUserService.myUpdateById(jdUser);
        byId = jdUserService.getById("1");
        System.out.println("byId = " + byId);


        JdUserMapper bean = run.getBean(JdUserMapper.class);
//        list = jdUserService.list();
//        System.out.println("list = " + list);

//        System.out.println("i = " + i);

    }

}
