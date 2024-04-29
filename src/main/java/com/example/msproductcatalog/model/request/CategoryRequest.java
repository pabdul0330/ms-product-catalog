    package com.example.msproductcatalog.model.request;

    import lombok.AccessLevel;
    import lombok.Data;
    import lombok.experimental.FieldDefaults;

    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Data
    public class CategoryRequest {

        String categoryName;
    }
