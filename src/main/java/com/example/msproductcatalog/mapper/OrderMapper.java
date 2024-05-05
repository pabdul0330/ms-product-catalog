package com.example.msproductcatalog.mapper;

import com.example.msproductcatalog.dao.entity.BasketEntity;
import com.example.msproductcatalog.dao.entity.OrderDetailsEntity;
import com.example.msproductcatalog.dao.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    default void mapRequestToEntity(BasketEntity entity, OrderDetailsEntity orderDetails, boolean status) {
        entity.setOrderDetails(orderDetails);
        entity.setStatus(status);
    }
}
