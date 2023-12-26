package com.aliyun.controller;

import io.prometheus.client.Gauge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * gauge example
 */
@RestController
public class GaugeController {

    private Gauge gauge = Gauge.build().name("native_gauge_v1").help("gauge help!").labelNames("service_name").register();

    @GetMapping("/gauge")
    public String ping(){
        //具体的业务逻辑 TODO
        gauge.labels("springboot1.5.21.x-native-prometheus").set(new Random().nextInt(10));
        return "gauge access success!";
    }
}