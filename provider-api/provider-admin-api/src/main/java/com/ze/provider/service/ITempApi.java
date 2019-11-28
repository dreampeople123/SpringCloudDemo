package com.ze.provider.service;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Date 2019/11/5 14:49
 * @Author GaoZien
 * @Desc TODO
 */
public interface ITempApi {

    @GetMapping(value = "/temphi")
    String temphi();
}
