package com.aliyun.pushgateway;

import com.aliyun.config.PMetricConfig;
import io.prometheus.client.exporter.PushGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URL;

@Service
public class PushGatewayServer {

    private PushGateway pushGateway;

    @Autowired
    private PMetricConfig pMetricConfig;

    @PostConstruct
    public void init(){
        try{
            pushGateway = new PushGateway(new URL(pMetricConfig.getEndpoint()));
        }catch (Throwable e){
            e.printStackTrace();
        }
    }

    public PushGateway getPushGateway() {
        return pushGateway;
    }
}
