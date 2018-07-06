package com.zq.learn.userservice.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/7/6
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String ENERGY_SERVICE = "ENERGY-SERVICE";

    @GetMapping("/usedElectric/{userId}")
    public Double getUsedElectricByDay(@PathVariable("userId") long userId){
        return restTemplate.getForObject("http://{1}/energy/dayElectric",Double.class,ENERGY_SERVICE);
    }
}
