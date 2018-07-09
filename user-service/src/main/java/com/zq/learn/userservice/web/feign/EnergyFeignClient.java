package com.zq.learn.userservice.web.feign;

import com.zq.learn.userservice.common.ExcludeGlobalScan;
import com.zq.learn.userservice.conf.feign.FeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/7/9
 **/
@FeignClient(name = "ENERGY-SERVICE",configuration = FeignConfiguration.class)
public interface EnergyFeignClient {

    @GetMapping("/energy/dayElectric")
    Double getUsedElectricByDay();
}
