package com.aliyun.controller;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * timer example demo1: use default
 */
@RestController
public class TimerOneController {

    @GetMapping("/timer1")
    public String ping(){
        Timer timer = Metrics.timer("springboot.timer1.api.request.duration",
                "service.name","springboot2.x-micrometer-prometheus");
        long start = System.currentTimeMillis();
        try{
            //具体的业务逻辑 TODO
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        }catch (Exception e){

        }finally {
            timer.record(System.currentTimeMillis() - start,TimeUnit.MILLISECONDS);
        }
        return "timer1 access success!";
    }
}