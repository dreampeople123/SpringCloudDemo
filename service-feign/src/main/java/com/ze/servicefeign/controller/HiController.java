package com.ze.servicefeign.controller;

import com.ze.servicefeign.clients.SchedualServiceHi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2019/10/28 17:20
 * @Author GaoZien
 * @Desc TODO
 */
@RestController
public class HiController {

    private static final Logger LOG = LoggerFactory.getLogger(HiController.class);

    @Autowired
    @Qualifier("servicehi")
    SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne( name );
    }

    @RequestMapping("/ziphi")
    public String home(){
        LOG.info("hi is being called");
        return "hi i'm miya!";
    }

    @RequestMapping("/info")
    public void info(){
        LOG.info("info is being called");

//        return schedualServiceHi.zipHi("http://localhost:8988/info",String.class);
    }


}
