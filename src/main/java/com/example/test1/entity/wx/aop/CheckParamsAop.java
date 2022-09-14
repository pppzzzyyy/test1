package com.example.test1.entity.wx.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author : panzhenye
 * @date : 2022/9/13 19:51
 */
@Aspect
@Component
@Slf4j
public class CheckParamsAop {

    /**
     * 所有加了{@link NotBlank}注解的方法，里面带有{@link NotBlank}注解的属性不能为空
     *
     * @param point
     * @return
     */
    @Around("@annotation(NotBlank)")
    public String checkParamsNotBlank(ProceedingJoinPoint point) {
        StringBuilder msg = new StringBuilder();
        Object[] args = point.getArgs();
        for (Object arg : args) {
            msg.append(WxUtil.checkParamsNotBlank(arg));
        }
        if (StringUtils.isNotBlank(msg)) {
            return msg.toString();
        } else {
            try {
                return (String) point.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                return null;
            }
        }
    }
}
