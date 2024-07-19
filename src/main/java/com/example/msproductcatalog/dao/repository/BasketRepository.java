package com.example.msproductcatalog.dao.repository;

import com.example.msproductcatalog.dao.entity.BasketEntity;
import com.example.msproductcatalog.dao.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<BasketEntity,Long>{
}
