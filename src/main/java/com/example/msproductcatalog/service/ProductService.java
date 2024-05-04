package com.example.msproductcatalog.service;

import com.example.msproductcatalog.dao.entity.CategoryEntity;
import com.example.msproductcatalog.dao.entity.ProductEntity;
import com.example.msproductcatalog.dao.repository.CategoryRepository;
import com.example.msproductcatalog.dao.repository.ProductRepository;
import com.example.msproductcatalog.mapper.ProductMapper;
import com.example.msproductcatalog.model.request.ProductRequest;
import com.example.msproductcatalog.model.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public void addProduct(ProductRequest request) {
        ProductEntity productEntity = ProductMapper.INSTANCE.
                mapRequestToEntity(request);
        productRepository.save(productEntity);
    }

    public List<ProductResponse> getProducts() {
        List<ProductEntity> all = productRepository.findAll();
        return ProductMapper.INSTANCE.mapEntityListToResponseList(all);
    }

    public ProductResponse getProductById(long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow();
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
}
