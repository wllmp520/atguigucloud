package com.atguigu.springcloud.controller;

import cn.hutool.core.lang.UUID;
import com.atguigu.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/getzk")
    public CommonResult getZk(){
        return new CommonResult(200,"serverPort"+serverPort, UUID.fastUUID());
    }
}
