package com.ze.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
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
public class HelloController {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String home(@RequestParam(value = "name", defaultValue = "forezp")  String name) {
        return "hi " + name + " ,i am from port:" + port;
    }


}
