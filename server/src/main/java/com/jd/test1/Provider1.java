package com.jd.test1;

import com.jd.jsf.gd.config.annotation.Provider;
import com.jd.jsf.gd.config.annotation.Server;
import org.springframework.stereotype.Service;

/**
 * @author : panzhenye
 * @date : 2022/9/23 15:23
 */
@Service
@Provider(alias = "test1", register = false, server = {@Server(host = "127.0.0.1", port = 22001)})
public class Provider1 implements TestJsfApi {
    @Override
    public String test(String a) {
        System.out.println("a = " + a);
        return "success";
    }
}
