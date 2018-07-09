package com.zq.learn.userservice.common;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/7/9
 **/
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Qualifier
public @interface MyBean {
}
