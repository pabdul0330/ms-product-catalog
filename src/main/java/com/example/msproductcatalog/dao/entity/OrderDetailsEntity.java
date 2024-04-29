package com.example.msproductcatalog.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Data

public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;
    String customerName;
    @Column(length = 512)
    String customerAddress;

    @OneToOne
    @JoinColumn(name = "basket_id", referencedColumnName = "Id")
    private BasketEntity basket;


    @CreationTimestamp
    LocalDate createdAt;
    @UpdateTimestamp
    LocalDate updatedAt;
}
