package com.example.msproductcatalog.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailsRequest {

    @NotBlank(message = "CUSTOMER_NAME_CAN_NOT_BE_EMPTY")
    String customerName;
    @NotBlank(message = "CUSTOMER_ADDRESS_CAN_NOT_BE_EMPTY")
    String customerAddress;
    String email;
    long basketId;
}
