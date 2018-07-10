package com.zq.learn.userservice.service.impl;

import com.zq.learn.energyservice.api.EnergyFeign;
import com.zq.learn.energyservice.api.dto.PointValue;
import com.zq.learn.energyservice.api.dto.TimeRegion;
import com.zq.learn.energyservice.api.dto.TimeValue;
import com.zq.learn.userservice.service.IEnergyService;
import com.zq.learn.userservice.service.IFeignEnergyService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/7/10
 **/
@Component
public class EnergyServiceFallback implements IFeignEnergyService {

    @Override
    public double getDayElectric() {
        return 0;
    }

    @Override
    public double getMonthElectric(Date month) {
        return 0;
    }

    @Override
    public List<TimeValue<PointValue>> getPointValues(Date day) {
        return null;
    }

    @Override
    public List<TimeValue<PointValue>> getPointValues(TimeRegion timeRegion) {
        return null;
    }
}
