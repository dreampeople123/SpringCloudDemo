package com.ze.eurekaclient.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Date 2019/10/31 17:42
 * @Author GaoZien
 * @Desc TODO
 */
@FeignClient(value = "service-feign", fallback = SchedualServiceInfoImpl.class)
public interface SchedualServiceInfo {

    @RequestMapping(value = "/ziphi",method = RequestMethod.GET)
    String sayZipHiFromClientOne();

}
