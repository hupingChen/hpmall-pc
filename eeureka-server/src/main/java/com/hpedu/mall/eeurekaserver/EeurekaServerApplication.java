package com.hpedu.mall.eeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EeurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EeurekaServerApplication.class, args);
    }

}
