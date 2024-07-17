package com.example.msproductcatalog.service;

import com.example.msproductcatalog.client.MailSenderClient;
import com.example.msproductcatalog.dao.entity.BasketEntity;
import com.example.msproductcatalog.dao.entity.OrderDetailsEntity;
import com.example.msproductcatalog.dao.repository.BasketRepository;
import com.example.msproductcatalog.mapper.OrderDetailsMapper;
import com.example.msproductcatalog.mapper.OrderMapper;
import com.example.msproductcatalog.model.request.OrderDetailsRequest;
import com.example.msproductcatalog.model.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final BasketRepository basketRepository;
    private final MailSenderClient mailSenderClient;
    private final ProductService productService;

    public void addOrder(OrderDetailsRequest detailsRequest) {
        BasketEntity basketEntity = basketRepository.findById(detailsRequest.getBasketId()).orElseThrow();
        OrderDetailsEntity orderDetailsEntity = OrderDetailsMapper.INSTANCE.mapRequestToEntity(detailsRequest, basketEntity);
        OrderMapper.INSTANCE.mapRequestToEntity(basketEntity, orderDetailsEntity, true);

        productService.editProductsForCount(basketEntity.getProducts());
        basketRepository.save(basketEntity);
        CompletableFuture.runAsync(() -> {
            mailSenderClient.sendMail(
                    new UserRequest(detailsRequest.getCustomerName(), detailsRequest.getEmail()));
        });
    }
}
