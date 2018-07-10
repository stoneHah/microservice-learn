package com.zq.learn.energyservice.api;

import com.zq.learn.energyservice.api.dto.PointValue;
import com.zq.learn.energyservice.api.dto.TimeRegion;
import com.zq.learn.energyservice.api.dto.TimeValue;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/7/10
 **/
//@RequestMapping("/energy-feign")
public interface EnergyFeign {

    @GetMapping("/dayElectric")
    double getDayElectric();

    @GetMapping("/monthElectric")
    double getMonthElectric(@RequestHeader("month") Date month);

    @GetMapping("/dailyPointValues")
    List<TimeValue<PointValue>> getPointValues(@RequestParam("day") Date day);

    @PostMapping("/regionPointValues")
    List<TimeValue<PointValue>> getPointValues(@RequestBody TimeRegion timeRegion);
}
