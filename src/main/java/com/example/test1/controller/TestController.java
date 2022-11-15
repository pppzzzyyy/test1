package com.example.test1.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.test1.entity.JdUser;
import com.example.test1.mapper.JdUserMapper;
import com.example.test1.service.JdUserService;
import com.example.test1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author : panzhenye
 * @date : 2022/9/7 18:14
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private JdUserService jdUserService;

    @Autowired
    private JdUserMapper jdUserMapper;

    @RequestMapping("test1")
    public String test1(){
        List<JdUser> list = jdUserService.list();
        System.out.println("list = " + list);
        List<JdUser> jdUsers = jdUserMapper.selectList(Wrappers.emptyWrapper());
        System.out.println("jdUsers = " + jdUsers);
        return "success";
    }

    public String test2(){
        List<JdUser> listByName = jdUserMapper.getListByName("1");
        System.out.println("listByName = " + listByName);
        List<JdUser> listByName1 = jdUserMapper.getListByName("");
        System.out.println("listByName1 = " + listByName1);
        List<JdUser> listByName2 = jdUserMapper.getListByName(null);
        System.out.println("listByName2 = " + listByName2);
        return "success";
    }

    public String test3(){
        JdUser listByName = jdUserMapper.getListById("1");
        System.out.println("listByName = " + Optional.ofNullable(listByName).orElse(new JdUser()).getJdUserId());
        return "success";
    }

    public String test4() throws InterruptedException {
        JdUser jdUser = new JdUser();
        jdUser.setJdUserId("10");
        jdUser.setJdUserText1("0");
        for (int i = 0; i < 2; i++) {
            testService.test41(jdUser);
        }

        return "success";
    }

    public void test5() {
        JdUser jdUser = new JdUser();
        jdUser.setJdUserName("11");
//        jdUser.setJdUserText1("11");
        jdUser.setJdUserId("10");
        jdUserMapper.testSet(jdUser);
    }
}
