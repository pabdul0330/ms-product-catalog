package com.example.msproductcatalog.controller;

import com.example.msproductcatalog.model.request.OrderDetailsRequest;
import com.example.msproductcatalog.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public void addOrder(@RequestBody OrderDetailsRequest request) {
        orderService.addOrder(request);
    }
}
