package com.aliyun.pushgateway;

import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import org.springframework.stereotype.Service;

@Service
public class MetricProvider {
    private Counter counter = Counter.build().name("native_counter_requests_v2").help("Total requests.").labelNames("service_name").register();
    private Gauge gauge = Gauge.build().name("native_gauge_v2").help("gauge help!").labelNames("service_name").register();

    public Counter getCounter() {
        return counter;
    }

    public Gauge getGauge() {
        return gauge;
    }
}
