package com.aliyun.controller;

import io.micrometer.core.instrument.Metrics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * gauge example demo1:
 */
@RestController
public class GaugeOneController {

    private AtomicInteger atomicInteger = Metrics.gauge("springboot.gauge1",new AtomicInteger(0));

    @GetMapping("/gauge1")
    public String ping(){
        //具体的业务逻辑 TODO
        atomicInteger.set(new Random().nextInt(10));
        return "gauge1 access success!";
    }
}