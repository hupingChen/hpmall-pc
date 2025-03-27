package com.hpedu.mall.hpmallprotal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

    @Autowired
    private LoadBalancerClient loadBalancerClient;

/*    private String getGoodsServer(){
        String serverList="http://localhost:9090/goods,http://localhost:9093/goods";
        String servers[]=serverList.split(",");
        Random random=new Random();
        return servers[random.nextInt(servers.length)];
    }*/


    @GetMapping
    public String order(){
        log.info("began in order");
/*        ServiceInstance choose = loadBalancerClient.choose("goods-service");
        String goodsInfoUrl = String.format("http://%s:%s", choose.getHost(), choose.getPort());
        log.info("打印URL{}",goodsInfoUrl);*/
        String url = "http://goods-service/goods";
        String goodsInfo = restTemplate.getForObject(url, String.class);

        String promotionInfo = restTemplate.getForObject("http://marking-service/promotion", String.class);
        MultiValueMap<String,Object> param = new LinkedMultiValueMap<>();
        param.add("goodsInfo",goodsInfo);
        param.add("promotionInfo",promotionInfo);

        HttpEntity<MultiValueMap<String,Object>> httpEntity = new HttpEntity<>(param,new HttpHeaders());
        ResponseEntity<String> response = restTemplate.postForEntity("http://order-service/order", httpEntity, String.class);

        return response.getBody();
    }
}
