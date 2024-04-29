package com.example.msproductcatalog.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {

    String productName;
    long categoryId;
    String productDescription;
    int productCount;
    double productPrice;

}
