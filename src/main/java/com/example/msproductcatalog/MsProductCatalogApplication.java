package com.example.msproductcatalog;

import jakarta.websocket.ClientEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsProductCatalogApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsProductCatalogApplication.class, args);
    }
}
