package com.example.msproductcatalog.model.response;

import com.example.msproductcatalog.model.request.CategoryRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    long Id;
    String productName;
    CategoryRequest category;
    String productDescription;
    int productCount;
    double productPrice;
}
