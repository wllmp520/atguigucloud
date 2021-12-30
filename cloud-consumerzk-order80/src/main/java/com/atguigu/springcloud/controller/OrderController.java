package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    private final static String INVOKE_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumerzk/getzk")
    public CommonResult getZk(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/getzk",CommonResult.class);
    }
}
