package com.example.msproductcatalog.service;

import com.example.msproductcatalog.dao.entity.BasketEntity;
import com.example.msproductcatalog.dao.entity.ProductEntity;
import com.example.msproductcatalog.dao.repository.BasketRepository;
import com.example.msproductcatalog.dao.repository.ProductRepository;
import com.example.msproductcatalog.mapper.BasketMapper;
import com.example.msproductcatalog.model.request.BasketRequest;
import com.example.msproductcatalog.model.response.BasketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;
    private final ProductRepository productRepository;

    public void addBasket(BasketRequest request) {
        List<ProductEntity> products = productRepository.findAllById(request.getProductIds());
        BasketEntity basketEntity = BasketMapper.INSTANCE.requestToEntity(
                request,
                products,
                products.stream().mapToDouble(ProductEntity::getProductPrice).sum());
        basketRepository.save(basketEntity);
    }

    public List<BasketResponse> getBaskets() {
        List<BasketEntity> all = basketRepository.findAll();
        return BasketMapper.INSTANCE.mapEntityListToResponseList(all.stream().filter(it-> !it.isStatus()).toList());
    }

    public void editBasket(BasketRequest request, long id) {
        List<ProductEntity> productEntities = productRepository.findByIdIn(request.getProductIds());
        basketRepository.save(BasketMapper.INSTANCE.mapRequestToEntity(
                id,
                productEntities,
                productEntities.stream().mapToDouble(ProductEntity::getProductPrice).sum()));

    }
}
