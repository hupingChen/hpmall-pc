package com.hpedu.mall.hpmallprotal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 *
 * @Author CHP
 * @Date：2025/3/25
 * @Description：订单模块功能模拟
 *
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;




    private String getGoodsServer(){
        String serverList="http://localhost:9090/goods,http://localhost:9093/goods";
        String servers[]=serverList.split(",");
        Random random=new Random();
        return servers[random.nextInt(servers.length)];
    }


    @GetMapping
    public String order(){
        log.info("began in order");
        String goodsInfo = restTemplate.getForObject(getGoodsServer(), String.class);
        String promotionInfo = restTemplate.getForObject("http://localhost:9091/promotion", String.class);
        MultiValueMap<String,Object> param = new LinkedMultiValueMap<>();
        param.add("goodsInfo",goodsInfo);
        param.add("promotionInfo",promotionInfo);

        HttpEntity<MultiValueMap<String,Object>> httpEntity = new HttpEntity<>(param,new HttpHeaders());
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:9092/order", httpEntity, String.class);

        return response.getBody();
        //TODO 商品模块，查询商品信息
        //TODO 营销模块，查看促销信息
        //TODO 会员模块，查询会员信息
        //TODO 订单模块，查询订单信息


    }
}
