package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("+++++++插入结果"+i);
        if(i > 0){
            return new CommonResult(200,null);
        }else{
            return new CommonResult(201,"db insert failed");
        }
    }

    @GetMapping(value = "/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable long  id){
        Payment paymentById = paymentService.getPaymentById(id);
        if(Objects.nonNull(paymentById)){
            return new CommonResult(200,serverPort,paymentById);
        }else{
            return new CommonResult(201,"db22dddd222 find failed");
        }
    }
    @GetMapping(value = "/getdiscovery")
    public CommonResult getdiscovery(){
        final List<String> services = discoveryClient.getServices();
        final List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance :
                instances) {
            log.info(instance.getServiceId()+"=="+instance.getHost()+"=="+instance.getInstanceId()+"=="+instance.getPort()+"=="+instance.getUri()+"=="+instance.getScheme()+"=="+instance.getMetadata());
        }
        return new CommonResult(200,null,services);
    }
}
