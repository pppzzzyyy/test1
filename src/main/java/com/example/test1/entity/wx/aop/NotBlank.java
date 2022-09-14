package com.example.test1.entity.wx.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : panzhenye
 * @date : 2022/9/13 18:13
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlank {
    String value() default "";

    /**
     * 条件字段
     */
    String condition() default "" ;

    /**
     * 满足条件的值
     */
    String conditionValue() default "";

}
