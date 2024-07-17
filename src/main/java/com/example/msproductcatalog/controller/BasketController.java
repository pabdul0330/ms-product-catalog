package com.example.msproductcatalog.controller;

import com.example.msproductcatalog.model.request.BasketRequest;
import com.example.msproductcatalog.model.response.BasketResponse;

import com.example.msproductcatalog.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/basket")
public class BasketController {
    private final BasketService basketService;

    @GetMapping
    public List<BasketResponse> getBaskets() {
        return basketService.getBaskets();
    }

    @PreAuthorize("hasRole('SUPERUSER')")
    @PostMapping("/add")
    public void addBasket(@RequestBody BasketRequest basketRequest) {
        System.out.println("salam");
        basketService.addBasket(basketRequest);
    }

    @PutMapping("/{id}")
    public void editBasket(@PathVariable long id, @RequestBody BasketRequest request) {
        basketService.editBasket(request, id);
    }


}
