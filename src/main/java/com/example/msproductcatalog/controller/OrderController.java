package com.example.msproductcatalog.controller;

import com.example.msproductcatalog.model.request.OrderDetailsRequest;
import com.example.msproductcatalog.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
@Validated
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public void addOrder(@Valid @RequestBody OrderDetailsRequest request) {
        orderService.addOrder(request);
    }

}
