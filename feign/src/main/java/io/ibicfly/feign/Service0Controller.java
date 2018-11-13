package io.ibicfly.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service0Controller {
    @Autowired
    SchedualService0 schedualService0;
    @RequestMapping("/service01")// 这里指定的路径，代表直接访问Feign的路径
    public String serivce0()
    {
        return  schedualService0.service0();
    }
}
