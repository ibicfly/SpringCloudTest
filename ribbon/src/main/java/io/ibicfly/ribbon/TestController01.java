package io.ibicfly.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class TestController01 {
    @Autowired
     TestService01 testService01;
    @RequestMapping("/service0")
    public String hi()
    {
        return testService01.testService();
    }
}
