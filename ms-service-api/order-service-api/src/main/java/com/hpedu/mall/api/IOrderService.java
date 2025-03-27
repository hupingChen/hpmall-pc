package com.hpedu.mall.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IOrderService {


    @PostMapping("/order")
    public String getOrderById(@RequestParam String goodsInfo, @RequestParam String promotionInfo);
}
