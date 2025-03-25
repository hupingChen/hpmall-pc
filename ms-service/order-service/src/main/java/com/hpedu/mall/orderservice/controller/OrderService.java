package com.hpedu.mall.orderservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderService {

    @PostMapping("/order")
    public String getOrderById(@RequestParam String goodsInfo,@RequestParam String promotionInfo){
        log.info("开始创建订单，请求参数,{},{}",goodsInfo,promotionInfo);
        return "订单创建成功";
    }
}
