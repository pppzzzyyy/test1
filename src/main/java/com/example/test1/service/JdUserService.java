package com.example.test1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.test1.entity.JdUser;

import java.io.Serializable;
import java.util.List;

/**
 * @author : panzhenye
 * @date : 2022/9/7 19:50
 */
public interface JdUserService extends IService<JdUser> {
    @Override
    List<JdUser> list() ;

    @Override
    JdUser getById(Serializable id);

    Boolean myUpdateById(JdUser jdUser);
}
