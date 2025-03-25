package com.hpedu.mall.goodsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsService {


    /**
     *
     * @author CHP
     * @date 2025/3/25 8:51
     * @return String
     */

    @GetMapping("/goods")
    public String getGoodsById(){
        return "返回商品信息";
    }

}
