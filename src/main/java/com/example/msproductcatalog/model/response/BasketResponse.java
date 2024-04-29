package com.example.msproductcatalog.model.response;

import lombok.Data;

import java.util.List;

@Data
public class BasketResponse {

    double totalAmount;
    List<ProductResponse> products;

}
