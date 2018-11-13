package io.ibicfly.feign;

import org.springframework.stereotype.Component;

@Component
public class SchedualService0Err implements SchedualService0 {

    @Override
    public String service0() {
        return "serviceErr";
    }
}
