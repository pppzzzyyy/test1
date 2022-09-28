package com.jd.test1;

import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author : panzhenye
 * @date : 2022/9/23 15:23
 */
@RestController
@RequestMapping("provide1")
public class Provider1{

    @GetMapping("test")
    public String test(String a) {
        System.out.println("a = " + a);
        return "success";
    }

    @PostMapping("test1")
    public String test1(@RequestBody JdUser a) {
        System.out.println("a = " + a);
        return "success";
    }

    @GetMapping("test2")
    public String test2(@SpringQueryMap JdUser a) {
        System.out.println("a = " + a);
        return "success";
    }
}
