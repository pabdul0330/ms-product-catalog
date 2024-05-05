package com.example.msproductcatalog.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BasketResponse {
    long id;
    double totalAmount;
    List<ProductResponse> products;

}
