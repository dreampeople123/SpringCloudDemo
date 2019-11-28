package com.ze.provider.controller;

import com.ze.provider.service.ITempApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2019/11/6 9:15
 * @Author GaoZien
 * @Desc TODO
 */
@RestController
public class TempController implements ITempApi {

    @Override
    @GetMapping(value = "/temphi")
    public String temphi() {
        return "tempHi";
    }
}
