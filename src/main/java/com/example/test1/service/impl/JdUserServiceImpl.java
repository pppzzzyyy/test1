package com.example.test1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.test1.entity.JdUser;
import com.example.test1.mapper.JdUserMapper;
import com.example.test1.service.JdUserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author : panzhenye
 * @date : 2022/9/7 19:50
 */
@Service
public class JdUserServiceImpl extends ServiceImpl<JdUserMapper, JdUser> implements JdUserService {
}
