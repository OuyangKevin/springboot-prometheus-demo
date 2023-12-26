package com.aliyun.pushgateway;

import io.micrometer.core.instrument.util.NamedThreadFactory;
import io.prometheus.client.exporter.PushGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class MetricCollectorServer {

    @Autowired
    private PushGatewayServer pushGatewayServer;

    @Autowired
    private MetricProvider metricProvider;

    @PostConstruct
    public void init(){
        try{
            PushGateway pushGateway = pushGatewayServer.getPushGateway();
            if(pushGateway == null){
                System.err.println("push gateway init error!");
                return;
            }

            ScheduledExecutorService executor = Executors
                    .newSingleThreadScheduledExecutor(new NamedThreadFactory("pushgateway"));
            executor.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    try {
                        pushGateway.pushAdd(metricProvider.getCounter(),"__counter__");
                        pushGateway.pushAdd(metricProvider.getGauge(),"__gauge__");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }, 10, 5, TimeUnit.SECONDS);
        }catch (Throwable e){
            e.printStackTrace();
        }
    }
    
    
}
