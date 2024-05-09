package com.example.msproductcatalog.controller;

import com.example.msproductcatalog.model.request.BasketRequest;
import com.example.msproductcatalog.model.response.BasketResponse;
import com.example.msproductcatalog.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/basket")
public class BasketController {
    private final BasketService basketService;

    @PostMapping
    public void addBasket(@RequestBody BasketRequest basketRequest) {
        basketService.addBasket(basketRequest);
    }

    @GetMapping
    public List<BasketResponse> getBaskets() {
        return basketService.getBaskets();
    }

    @PutMapping("{id}")
    public void editBasket(@PathVariable long id, @RequestBody BasketRequest request) {
        basketService.editBasket(request, id);
    }


}
