package com.zq.learn.userservice.service;

import com.zq.learn.energyservice.api.EnergyFeign;
import com.zq.learn.userservice.service.impl.EnergyServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/7/10
 **/
@FeignClient(name = "ENERGY-SERVICE",path = "/energy-feign",fallback = EnergyServiceFallback.class)
public interface IFeignEnergyService extends EnergyFeign {
}
