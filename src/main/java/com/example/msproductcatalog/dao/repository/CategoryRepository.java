package com.example.msproductcatalog.dao.repository;

import com.example.msproductcatalog.dao.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
