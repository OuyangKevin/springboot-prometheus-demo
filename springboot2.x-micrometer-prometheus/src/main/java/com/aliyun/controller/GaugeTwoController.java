package com.aliyun.controller;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * gauge example demo2: 使用建造器流式创建,查看队列的长度
 */
@RestController
public class GaugeTwoController {

    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(500);
    private static BlockingQueue<Integer> real_queue;

    static {
        real_queue = Metrics.gauge("springboot.gauge2.queue.size", queue, Collection::size);

        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                    Integer message = real_queue.take();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    //no-op
                }
            }
        }).start();
    }

    @GetMapping("/gauge2")
    public String ping() throws Exception{
        //具体的业务逻辑 TODO
        real_queue.put(1);
        return "gauge2 access success!";
    }
}