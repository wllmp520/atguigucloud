package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping(("/consumer"))
@RestController
@Slf4j
public class ConsumeOrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @PostMapping("/payment/create")
    @ResponseBody
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/create",payment,CommonResult.class);
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/getPaymentById/"+id,CommonResult.class);
    }

    @GetMapping(value = "/getdiscovery")
    public CommonResult getdiscovery(){
        return restTemplate.getForObject(PAYMENT_URL+"/getdiscovery",CommonResult.class);
    }
}
