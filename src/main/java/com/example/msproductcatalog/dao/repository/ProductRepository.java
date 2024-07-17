package com.example.msproductcatalog.dao.repository;

import com.example.msproductcatalog.dao.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>,
        PagingAndSortingRepository<ProductEntity, Long>,JpaSpecificationExecutor<ProductEntity> {
//    Page<ProductEntity> findByProductNameContaining(String productName, Pageable pageable);
    List<ProductEntity> findAllByProductName(String productName, Pageable pageable);
    List<ProductEntity> findByIdIn(List<Long> ids);
}
