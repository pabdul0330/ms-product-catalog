package com.example.msproductcatalog.service;

import com.example.msproductcatalog.dao.entity.CategoryEntity;
import com.example.msproductcatalog.dao.entity.ProductEntity;
import com.example.msproductcatalog.dao.repository.CategoryRepository;
import com.example.msproductcatalog.dao.repository.ProductRepository;
import com.example.msproductcatalog.mapper.ProductMapper;
import com.example.msproductcatalog.model.exception.NotFoundException;
import com.example.msproductcatalog.model.request.ProductCriteriaRequest;
import com.example.msproductcatalog.model.request.ProductRequest;
import com.example.msproductcatalog.model.response.ProductResponse;
import com.example.msproductcatalog.service.specification.ProductSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public Page<ProductResponse> getProducts(ProductCriteriaRequest productCriteriaRequest, Pageable pageable) {
        Page<ProductEntity> all =
                productRepository.findAll
                        (ProductSpecification.getProductsByCriteria(productCriteriaRequest), pageable);
        return new PageImpl<>(ProductMapper.INSTANCE.mapEntityListToResponseList(all.getContent()));
    }

    public ProductResponse getProductById(long id) {
        ProductEntity productEntity = productRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Product not found"));
        return ProductMapper.INSTANCE.entityToResponse(productEntity);
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    public void editProductsForCount(List<ProductEntity> entities) {
        entities.forEach(i -> i.setProductCount(i.getProductCount() - 1));
    }

    public void editProduct(long id, ProductRequest productRequest) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow();
        CategoryEntity categoryEntity = null;
        if (productRequest.getCategoryId() != 0) {
            categoryEntity = categoryRepository.findById(productRequest.getCategoryId()).orElseThrow();
        }
        ProductMapper.INSTANCE.mapRequestToEntity(productEntity, categoryEntity, id, productRequest);
        productRepository.save(productEntity);
    }

    public static String encode(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    public void addProduct(ProductRequest productRequest) throws IOException {

        ProductEntity productEntity = ProductMapper.INSTANCE.
                mapRequestToEntity(productRequest);
        productRepository.save(productEntity);
    }

    public void addProductPhoto(long id, MultipartFile photo) throws IOException {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
        productEntity.setProductPhoto(Base64.getEncoder().encodeToString(photo.getBytes()));
        productRepository.save(productEntity);
    }

}
