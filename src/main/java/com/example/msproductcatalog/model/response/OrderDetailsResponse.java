package com.example.msproductcatalog.model.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailsResponse {

    String customerName;
    String customerAddress;
    BasketResponse basket;
}
