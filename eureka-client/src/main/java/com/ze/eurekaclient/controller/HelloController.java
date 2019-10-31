package com.ze.eurekaclient.controller;

import com.ze.eurekaclient.clients.SchedualServiceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2019/10/28 16:47
 * @Author GaoZien
 * @Desc TODO
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${server.port}")
    String port;

    @Value("${foo}")
    String foo;

    @Autowired
    private SchedualServiceInfo schedualServiceInfo;

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String home(@RequestParam(value = "name", defaultValue = "forezp")  String name) {
        return "hi " + name + " ,i am from port:" + port + ",foo:" + foo;
    }

    @RequestMapping(value = "/ziphi",method = RequestMethod.GET)
    public String callhome(@RequestParam(value = "name", defaultValue = "forezp")  String name) {
        LOG.info("calling trace service-hi");
        return schedualServiceInfo.sayZipHiFromClientOne();
    }


    @RequestMapping("/info")
    public String info(){
        LOG.info("calling trace service-hi ");
        return "i'm service-hi";
    }


}
