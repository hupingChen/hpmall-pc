package com.hpedu.mall.markingservice.controller;

import com.hpdeu.mall.api.IMarkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromotionService implements IMarkingService {

    @GetMapping("/promotion")
    public String getPromotionById(){
        return "查询到指定商品的促销信息";
    }

}
