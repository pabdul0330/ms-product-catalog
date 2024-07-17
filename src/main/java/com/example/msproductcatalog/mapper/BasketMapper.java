package com.example.msproductcatalog.mapper;

import com.example.msproductcatalog.dao.entity.BasketEntity;
import com.example.msproductcatalog.dao.entity.ProductEntity;
import com.example.msproductcatalog.model.request.BasketRequest;
import com.example.msproductcatalog.model.response.BasketResponse;
import com.example.msproductcatalog.model.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Mapper
public interface BasketMapper {
    BasketMapper INSTANCE = Mappers.getMapper(BasketMapper.class);

    @Mapping(target = "totalAmount", expression = "java(getTotalAmount(products))")
    BasketEntity requestToEntity(BasketRequest basketRequest, List<ProductEntity> products);

//    BasketResponse mapEntityToResponse(BasketEntity basketEntities, List<ProductResponse> products);

    default List<BasketResponse> mapEntityListToResponseList(List<BasketEntity> basketEntities) {
        return basketEntities.stream().map(i -> BasketResponse.builder().
                id(i.getId()).
                products(ProductMapper.INSTANCE.mapEntityListToResponseList(i.getProducts())).
                totalAmount(i.getTotalAmount())

                .build()).toList();
    }

    BasketEntity mapRequestToEntity(Long id, List<ProductEntity> products, double totalAmount);

    default double getTotalAmount(List<ProductEntity> products) {
        return products.stream().mapToDouble(ProductEntity::getProductPrice).sum();
    }
}
