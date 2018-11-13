package io.ibicfly.ribbon;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService01 {
    @Autowired
    RestTemplate restTemplate;
    public String testService() {
        return restTemplate.getForObject("http://SERVICE0/service0",String.class);
    }
}