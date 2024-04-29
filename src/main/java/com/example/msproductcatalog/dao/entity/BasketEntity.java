package com.example.msproductcatalog.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class BasketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    boolean status;
    double totalAmount;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "basketsandproducts",
            joinColumns = {@JoinColumn(name = "basket_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
            /*schema = "shopingSite"*/)
    List<ProductEntity> products;

    @OneToOne(mappedBy = "basket")
    OrderDetailsEntity orderDetails;

    @CreationTimestamp
    LocalDate createdAt;
    @UpdateTimestamp
    LocalDate updatedAt;
    //    OrderDetailsEntity orderDetails;
    //    long productIds;
}
