package com.example.msproductcatalog.service.specification;

import com.example.msproductcatalog.dao.entity.ProductEntity;
import com.example.msproductcatalog.model.request.ProductCriteriaRequest;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecification implements Specification<ProductEntity> {
    public static Specification<ProductEntity> getProductsByCriteria(ProductCriteriaRequest productCriteriaRequest) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (productCriteriaRequest.getProductName() != null && !productCriteriaRequest.getProductName().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("productName")), "%" + productCriteriaRequest.getProductName().toLowerCase() + "%"));
            }

            if (productCriteriaRequest.getMinPrice() != null && productCriteriaRequest.getMaxPrice() != null) {
                predicates.add(criteriaBuilder.between(root.get("productPrice"),
                        productCriteriaRequest.getMinPrice() , productCriteriaRequest.getMaxPrice()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    @Override
    public Specification<ProductEntity> and(Specification<ProductEntity> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<ProductEntity> or(Specification<ProductEntity> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
