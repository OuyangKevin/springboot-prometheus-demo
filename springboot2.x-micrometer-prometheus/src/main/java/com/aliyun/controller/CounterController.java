package com.aliyun.controller;

import io.micrometer.core.instrument.Metrics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * counter example
 */
@RestController
public class CounterController {

    @GetMapping("/counter")
    public String ping(){
        //具体的业务逻辑 TODO
        Metrics.counter("springboot.counter.access",
                "service.name", "springboot2.x-micrometer-prometheus",
                "regionId", "cn-hangzhou").increment();
        return "counter access success!";
    }
}