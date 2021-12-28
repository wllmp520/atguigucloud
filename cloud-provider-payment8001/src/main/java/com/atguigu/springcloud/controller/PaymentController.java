package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

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
            return new CommonResult(200,null,paymentById);
        }else{
            return new CommonResult(201,"db22dddd222 find failed");
        }
    }
}
