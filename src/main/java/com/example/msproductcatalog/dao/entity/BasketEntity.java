    package com.example.msproductcatalog.dao.entity;

    import jakarta.persistence.*;
    import lombok.Data;
    import org.hibernate.annotations.CreationTimestamp;
    import org.hibernate.annotations.UpdateTimestamp;

    import java.time.LocalDate;
    import java.util.List;

    @Entity
    @Data
    @Table(name = "baskets",schema = "shoppingsite")
    public class BasketEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        long id;
        boolean status;
        double totalAmount;
        @ManyToMany(cascade = CascadeType.MERGE)
        @JoinTable(name = "basketsandproducts",
                joinColumns = {@JoinColumn(name = "basket_id")},
                inverseJoinColumns = {@JoinColumn(name = "product_id")},
                schema = "shopingite")
        List<ProductEntity> products;

        @OneToOne(mappedBy = "basket",cascade = CascadeType.MERGE)
        OrderDetailsEntity orderDetails;

        @CreationTimestamp
        LocalDate createdAt;
        @UpdateTimestamp
        LocalDate updatedAt;
    }
