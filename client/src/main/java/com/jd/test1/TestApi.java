package com.jd.test1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : panzhenye
 * @date : 2022/9/28 14:06
 */
@FeignClient(value = "server",path = "provide1")
public interface TestApi {
    @GetMapping("test")
    String test(@RequestParam String a);

    @PostMapping("test1")
    String test1(@RequestBody JdUser a);
}
