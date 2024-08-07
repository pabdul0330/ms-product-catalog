package com.example.msproductcatalog.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderdetails",schema = "shoppingsite")

public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String customerName;
    @Column(length = 512)
    String customerAddress;
    String email;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "basket_id", referencedColumnName = "id")
    private BasketEntity basket;

    @CreationTimestamp
    LocalDate createdAt;
    @UpdateTimestamp
    LocalDate updatedAt;
}
