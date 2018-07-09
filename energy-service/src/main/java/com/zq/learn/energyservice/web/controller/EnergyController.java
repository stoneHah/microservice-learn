package com.zq.learn.energyservice.web.controller;

import com.zq.learn.energyservice.entity.PointValue;
import com.zq.learn.energyservice.entity.TimeRegion;
import com.zq.learn.energyservice.entity.TimeValue;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/7/6
 **/
@RestController
@RequestMapping("/energy")
public class EnergyController {

    @GetMapping("/dayElectric")
    public double getDayElectric() {
        return 1000 * Math.random();
    }

    @GetMapping("/monthElectric")
    public double getMonthElectric(
            @RequestHeader("month") @DateTimeFormat(pattern = "yyyy-MM-dd") Date month) {
        return 1000 * Math.random();
    }

    @GetMapping("/dailyPointValues")
    public List<TimeValue<PointValue>> getPointValues(
            @RequestParam("day") @DateTimeFormat(pattern = "yyyy-MM-dd") Date day){
        List<TimeValue<PointValue>> result = new ArrayList<>();
        result.add(new TimeValue<>(new Date(), new PointValue(20.2, 1)));
        result.add(new TimeValue<>(new Date(), new PointValue(20.3, 0)));

        return result;
    }

    @GetMapping("/regionPointValues")
    public List<TimeValue<PointValue>> getPointValues(
            @RequestBody TimeRegion timeRegion){
        List<TimeValue<PointValue>> result = new ArrayList<>();
        result.add(new TimeValue<>(new Date(), new PointValue(20.2, 1)));
        result.add(new TimeValue<>(new Date(), new PointValue(20.3, 0)));

        return result;
    }
}
