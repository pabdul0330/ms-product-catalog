package com.example.msproductcatalog.model.response;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {

    double totalAmount;
    List<ProductResponse> products;
    OrderDetailsResponse orderDetails;

}
