package com.aliyun.controller;

import com.aliyun.pushgateway.MetricProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * gauge example
 */
@RestController
public class GaugeController {

    @Autowired
    private MetricProvider metricProvider;

    @GetMapping("/gauge")
    public String ping(){
        //具体的业务逻辑 TODO
        metricProvider.getGauge().labels("springboot2.x-native-pushgateway").set(new Random().nextInt(10));
        return "gauge access success!";
    }
}