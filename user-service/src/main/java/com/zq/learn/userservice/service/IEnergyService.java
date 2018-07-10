package com.zq.learn.userservice.service;

import com.zq.learn.energyservice.api.dto.PointValue;
import com.zq.learn.energyservice.api.dto.TimeRegion;
import com.zq.learn.energyservice.api.dto.TimeValue;
import com.zq.learn.userservice.service.impl.EnergyServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/7/10
 **/
@FeignClient(name = "ENERGY-SERVICE",path = "/energy")
public interface IEnergyService {

    @GetMapping("/dayElectric")
    double getDayElectric();

    @GetMapping("/monthElectric")
    double getMonthElectric(@RequestHeader("month") Date month);

    @GetMapping("/dailyPointValues")
    List<TimeValue<PointValue>> getPointValues(@RequestParam("day") Date day);

    @PostMapping("/regionPointValues")
    List<TimeValue<PointValue>> getPointValues(@RequestBody TimeRegion timeRegion);
}
