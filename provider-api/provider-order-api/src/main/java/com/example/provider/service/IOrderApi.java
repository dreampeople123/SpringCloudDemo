package com.example.provider.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Date 2019/11/6 9:57
 * @Author GaoZien
 * @Desc TODO
 */
public interface IOrderApi {
    @GetMapping(value = "getOrder")
    public  String  getOrder(@RequestParam("orderId") Integer orderId);
}
