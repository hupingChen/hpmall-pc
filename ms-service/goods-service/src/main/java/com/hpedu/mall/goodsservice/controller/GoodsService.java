package com.hpedu.mall.goodsservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GoodsService {

    @Value("${server.port}")
    private String port;


    /**
     *
     * @author CHP
     * @date 2025/3/25 8:51
     * @return String
     */
    @GetMapping("/goods")
    public String getGoodsById(){
        log.info("收到请求端口为：{}的请求",port);
        return "返回商品信息";
    }

}
