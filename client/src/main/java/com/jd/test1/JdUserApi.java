package com.jd.test1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author : panzhenye
 * @date : 2022/9/28 14:58
 */
@FeignClient(value = "server", path = "jd/user", contextId = "jdUser")
public interface JdUserApi {

    @PostMapping
    public String add(@RequestBody JdUser jdUser);

    @DeleteMapping
    public String delete(@RequestParam String jdUserId);

    @PutMapping
    public String update(@RequestBody JdUser jdUser);

    @GetMapping
    public JdUser get(@SpringQueryMap JdUser jdUser);
}
