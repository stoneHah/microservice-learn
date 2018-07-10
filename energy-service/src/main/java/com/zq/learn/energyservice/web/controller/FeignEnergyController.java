package com.zq.learn.energyservice.web.controller;

import com.zq.learn.energyservice.api.EnergyFeign;
import com.zq.learn.energyservice.api.dto.PointValue;
import com.zq.learn.energyservice.api.dto.TimeRegion;
import com.zq.learn.energyservice.api.dto.TimeValue;
import com.zq.learn.stonecommon.utils.SleepUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/7/10
 **/
@RestController
@RequestMapping("/energy-feign")
public class FeignEnergyController implements EnergyFeign {

    private static Logger logger = LoggerFactory.getLogger(FeignEnergyController.class);

    @Override
    public double getDayElectric() {
        return 1000 * Math.random();
    }

    @Override
    public double getMonthElectric(@RequestHeader("month") Date month) {
        int sleepTime = new Random().nextInt(2000);
        logger.info("sleep {} sec",sleepTime);
        SleepUtils.sleepMill(sleepTime);

        return 1000 * 30 * Math.random();
    }

    @Override
    public List<TimeValue<PointValue>> getPointValues(@RequestParam("day") Date day) {
        List<TimeValue<PointValue>> result = new ArrayList<>();
        result.add(new TimeValue<>(new Date(), new PointValue(20.2, 1)));
        result.add(new TimeValue<>(new Date(), new PointValue(20.3, 0)));

        return result;
    }

    @Override
    public List<TimeValue<PointValue>> getPointValues(@RequestBody TimeRegion timeRegion) {
        List<TimeValue<PointValue>> result = new ArrayList<>();
        result.add(new TimeValue<>(new Date(), new PointValue(20.2, 1)));
        result.add(new TimeValue<>(new Date(), new PointValue(20.3, 0)));

        return result;
    }
}
