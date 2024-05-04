package com.example.msproductcatalog.dao.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String categoryName;
    //    long  productIds;
    @OneToMany(mappedBy = "category", cascade = CascadeType.MERGE)
    List<ProductEntity> products;
}
