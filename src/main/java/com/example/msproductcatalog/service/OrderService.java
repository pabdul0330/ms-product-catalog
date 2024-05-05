package com.example.msproductcatalog.service;

import com.example.msproductcatalog.dao.entity.BasketEntity;
import com.example.msproductcatalog.dao.entity.OrderDetailsEntity;
import com.example.msproductcatalog.dao.repository.BasketRepository;
import com.example.msproductcatalog.mapper.OrderDetailsMapper;
import com.example.msproductcatalog.mapper.OrderMapper;
import com.example.msproductcatalog.model.request.OrderDetailsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final BasketRepository basketRepository;
    private final ProductService productService;

    public void addOrder(OrderDetailsRequest detailsRequest) {
        BasketEntity basketEntity = basketRepository.findById(detailsRequest.getBasketId()).orElseThrow();
//        basketEntity.setProducts(basketEntity.getProducts().
//                stream().
//                peek(product -> product.setProductCount(product.getProductCount() - 1)).
//                toList());

        OrderDetailsEntity orderDetailsEntity = OrderDetailsMapper.INSTANCE.mapRequestToEntity(detailsRequest, basketEntity);
        productService.editProductsForCount(basketEntity.getProducts());
        OrderMapper.INSTANCE.mapRequestToEntity(basketEntity, orderDetailsEntity, true);

        basketRepository.save(basketEntity);
    }
}
