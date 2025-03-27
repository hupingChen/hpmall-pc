package com.hpedu.mall.api;

import org.springframework.web.bind.annotation.GetMapping;

public interface IMarkingService {

    @GetMapping("/promotion")
    String getPromotionById();

}