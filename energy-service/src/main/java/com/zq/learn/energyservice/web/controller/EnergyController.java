package com.zq.learn.energyservice.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public double getDayElectric(){
        return 1000 * Math.random();
    }
}
