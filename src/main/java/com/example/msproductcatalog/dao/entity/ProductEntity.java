package com.example.msproductcatalog.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products", schema = "shoppingsite")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String productName;
    @Lob
    private String productPhoto;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn
    private CategoryEntity category;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.MERGE)
    List<BasketEntity> baskets;

    @Column(columnDefinition = "TEXT")
    String productDescription;
    int productCount;
    double productPrice;
    @CreationTimestamp
    LocalDate createdAt;
    @UpdateTimestamp
    LocalDate updatedAt;
}
