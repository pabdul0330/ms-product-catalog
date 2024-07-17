package com.example.msproductcatalog.model.request;

import lombok.Data;

@Data
public class ProductCriteriaRequest {
    String productName;
    Double minPrice;
    Double maxPrice;
}
