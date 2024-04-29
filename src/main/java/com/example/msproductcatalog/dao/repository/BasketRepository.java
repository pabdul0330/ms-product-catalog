package com.example.msproductcatalog.dao.repository;

import com.example.msproductcatalog.dao.entity.BasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<BasketEntity, Long> {
}
