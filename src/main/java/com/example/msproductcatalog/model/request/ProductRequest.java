package com.example.msproductcatalog.model.request;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {

    long categoryId;
    @NotBlank(message = "Please enter product description.")
    @Size(max = 1000)
    String productDescription;
    int productCount;
    String productName;
    @ApiModelProperty(dataType = "double", example = "12.5")
    double productPrice;

}
