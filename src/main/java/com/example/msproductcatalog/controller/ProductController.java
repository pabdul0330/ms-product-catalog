package com.example.msproductcatalog.controller;

import com.example.msproductcatalog.model.request.ProductRequest;
import com.example.msproductcatalog.model.response.ProductResponse;
import com.example.msproductcatalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public void addProduct(@RequestBody ProductRequest request) {
        productService.addProduct(request);
    }

    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.getProducts();
    }

    @PutMapping("edit/{id}")
    public void editProduct(@PathVariable long id, @RequestBody ProductRequest request) {
        productService.editProduct(id, request);
    }
}
