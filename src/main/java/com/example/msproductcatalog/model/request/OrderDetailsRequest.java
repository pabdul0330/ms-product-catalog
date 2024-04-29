package com.example.msproductcatalog.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailsRequest {

    String customerName;
    String customerAddress;
    long basketId;
}
