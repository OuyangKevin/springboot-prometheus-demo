package com.aliyun.controller;

import io.prometheus.client.Counter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * counter example
 */
@RestController
public class CounterController {

    private Counter counter = Counter.build().name("native_counter_requests_v1").help("Total requests.").labelNames("service_name").register();

    @GetMapping("/counter")
    public String ping(){
        //具体的业务逻辑 TODO
        counter.labels("springboot1.5.21.x-native-prometheus").inc();
        return "counter access success!";
    }
}