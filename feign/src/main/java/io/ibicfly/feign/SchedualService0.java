package io.ibicfly.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="service0",fallback = SchedualService0Err.class)//代表去找serviceo0服务
public interface SchedualService0 {
    @RequestMapping("/service0")//找指定服务下的service0方法
    String service0();
}
