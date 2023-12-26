package com.aliyun.pushgateway;

import com.aliyun.config.MetricConfig;
import io.prometheus.client.exporter.PushGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URL;

@Service
public class PushGatewayServer {

    private PushGateway pushGateway;

    @Autowired
    private MetricConfig metricConfig;

    @PostConstruct
    public void init(){
        try{
            pushGateway = new PushGateway(new URL(metricConfig.getEndpoint()));
        }catch (Throwable e){
            e.printStackTrace();
        }
    }

    public PushGateway getPushGateway() {
        return pushGateway;
    }
}
