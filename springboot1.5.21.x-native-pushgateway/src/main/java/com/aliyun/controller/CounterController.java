package com.aliyun.controller;

import com.aliyun.pushgateway.MetricProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * counter example
 */
@RestController
public class CounterController {

    @Autowired
    private MetricProvider metricProvider;

    @GetMapping("/counter")
    public String ping(){
        //具体的业务逻辑 TODO
        metricProvider.getCounter().labels("springboot1.5.21.x-native-pushgateway").inc();
        return "counter access success!";
    }
}