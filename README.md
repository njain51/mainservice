# mainservice

- 3 mincroservices: 
  - https://github.com/sample-projects-only/mainservice  running on 8080
  - https://github.com/sample-projects-only/service1 running on 8081
  - https://github.com/sample-projects-only/service2 running on 8082
  - mainservice is calling service1 and service1 calling service2

- run zipkin locally via docker:
```
docker run -d -p 9411:9411 openzipkin/zipkin
```

- testing:
```
curl http://localhost:8080/getmainsleuthtest
```
  - check trace in zipkin it should show service1 and service2
  - currently only traceability is coming between mainservice and service1. 
