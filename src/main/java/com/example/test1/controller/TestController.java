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
}
