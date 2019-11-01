package com.ze.servicefeign.clients;

import org.springframework.stereotype.Component;

/**
 * @Date 2019/10/29 17:00
 * @Author GaoZien
 * @Desc TODO
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }

    @Override
    public String sayinfo() {
        return "sorry 123";
    }
}
