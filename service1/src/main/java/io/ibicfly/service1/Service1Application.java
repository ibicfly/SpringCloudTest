package io.ibicfly.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Service1Application {
    //这样
    @GetMapping("service0")
    public String service1()
    {
        return "service1";
    }
    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class, args);
    }
}
