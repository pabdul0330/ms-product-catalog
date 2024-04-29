package com.example.msproductcatalog.model.response;

import com.example.msproductcatalog.model.request.CategoryRequest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryResponse {
    long Id;
    String categoryName;
    List<ProductResponseForCategory> products;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class ProductResponseForCategory {
        String productName;
        String productDescription;
        int productCount;
        double productPrice;
    }}
