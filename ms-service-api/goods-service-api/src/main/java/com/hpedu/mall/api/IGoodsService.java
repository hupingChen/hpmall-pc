package com.hpedu.mall.api;

import org.springframework.web.bind.annotation.GetMapping;

public interface IGoodsService {

    @GetMapping("/goods")
    public String getGoodsById();
}
