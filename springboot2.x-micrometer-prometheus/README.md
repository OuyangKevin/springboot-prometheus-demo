# springboot2.x-micrometer-prometheus
## 1. Start application
run main class "SpringBootPrometheusApplication"

## 2. API

### 2.1 Counter API
```
http://127.0.0.1:8082/counter
```
### 2.2 Gauge API
(1) demo1
```
http://127.0.0.1:8082/gauge1
```
(2) demo2
```
http://127.0.0.1:8082/gauge2
```
### 2.2 Timer API
(1) demo1
```
http://127.0.0.1:8082/timer1
```
(2) demo2
```
http://127.0.0.1:8082/timer2
```
## 2.3 Prometheus Metrics
```
http://127.0.0.1:13142/actuator/prometheus
```