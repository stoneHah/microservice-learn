package com.zq.learn.userservice.common;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * 不包含在全局的bean 扫描中
 *
 * @author qun.zheng
 * @create 2018/7/9
 **/
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Qualifier
public @interface ExcludeGlobalScan {
}
