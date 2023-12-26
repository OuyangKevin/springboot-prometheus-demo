# springboot1.5.21.x-native-prometheus
## 1. Start application
run main class "SpringBootPrometheusApplication"

## 2. API

### 2.1 Counter API
```
http://127.0.0.1:8083/counter
```
### 2.2 Gauge API
```
http://127.0.0.1:8083/gauge
```

## 2.3 Prometheus Metrics
```
http://127.0.0.1:8083/metrics
```
for example:
```
# HELP native_gauge_v1 gauge help!
# TYPE native_gauge_v1 gauge
native_gauge_v1{service_name="springboot1.5.21.x-native-prometheus",} 9.0
# HELP native_counter_requests_v1_total Total requests.
# TYPE native_counter_requests_v1_total counter
native_counter_requests_v1_total{service_name="springboot1.5.21.x-native-prometheus",} 1.0
# HELP native_counter_requests_v1_created Total requests.
# TYPE native_counter_requests_v1_created gauge
native_counter_requests_v1_created{service_name="springboot1.5.21.x-native-prometheus",} 1.703590599789E9
```