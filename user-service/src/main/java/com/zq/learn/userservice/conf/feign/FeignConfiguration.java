package com.zq.learn.userservice.conf.feign;

import com.zq.learn.userservice.common.ExcludeGlobalScan;
import feign.Contract;
import feign.Contract.Default;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/7/9
 **/
@Configuration
@ExcludeGlobalScan
public class FeignConfiguration {

    public FeignConfiguration() {
        System.out.println("++++++++++++FeignConfiguration is configed++++++++++");
    }

    /*@Bean
    public Contract feignContract(){
        return new Default();
    }*/
}
