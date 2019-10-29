package com.ze.serviceribbon.controler;

import com.ze.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2019/10/29 15:59
 * @Author GaoZien
 * @Desc TODO
 */
@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;

    /**
    　* @description: 测试url http://localhost:8764/hi?name=forezp
    　* @author GaoZien
    　* @date 2019/10/29
    */
    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }
}
