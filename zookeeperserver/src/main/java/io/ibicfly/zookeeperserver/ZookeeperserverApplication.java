package io.ibicfly.zookeeperserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.zookeeper.ConditionalOnZookeeperEnabled;

@SpringBootApplication
@ConditionalOnZookeeperEnabled
public class ZookeeperserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperserverApplication.class, args);
    }
}
