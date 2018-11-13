package io.ibicfly.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverApplication {

    public static void main(String[] args) {
        //Eureka注册中心修改
        System.out.println("EurekaserverApplication");
        SpringApplication.run(EurekaserverApplication.class, args);
    }

}
