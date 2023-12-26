package com.aliyun.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * timer example demo2: use annotation
 */
@RestController
public class TimerTwoController {

    @Timed(value = "springboot.timer2.api.request.duration", description = "Time taken to return timer api", histogram = true)
    @GetMapping("/timer2")
    public String ping(){
        //具体的业务逻辑 TODO
        try{
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        }catch (Exception e){

        }finally {

        }
        return "timer2 access success!";
    }
}