package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.atguigu.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

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
            log.info("+++++++结果成功");
            return new CommonResult(200,serverPort,paymentById);
        }else{
            return new CommonResult(201,"db22dddd222 find failed");
        }
    }
}
