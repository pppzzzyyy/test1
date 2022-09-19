package com.example.test1.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.test1.entity.JdUser;
import com.example.test1.mapper.JdUserMapper;
import com.example.test1.service.JdUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author : panzhenye
 * @date : 2022/9/7 19:50
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "JdUser")
public class JdUserServiceImpl extends ServiceImpl<JdUserMapper, JdUser> implements JdUserService {
    @Override
    @Cacheable
    public List<JdUser> list() {
        log.info("查询list");
        return this.list(Wrappers.emptyWrapper());
    }

    @Override
    @Cacheable
    public JdUser getById(Serializable jdUserId) {
        log.info("查询id:{}",jdUserId);
        return this.getBaseMapper().selectById(jdUserId);
    }

    @Override
    @CacheEvict(key = "#jdUser.jdUserId")
    public Boolean myUpdateById(JdUser jdUser) {
        log.info("修改id:{}",jdUser.getJdUserId());
        return updateById(jdUser);
    }
}
