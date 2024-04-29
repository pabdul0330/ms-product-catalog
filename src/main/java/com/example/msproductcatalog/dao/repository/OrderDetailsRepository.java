package com.example.msproductcatalog.dao.repository;

import com.example.msproductcatalog.dao.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity,Long> {
}
