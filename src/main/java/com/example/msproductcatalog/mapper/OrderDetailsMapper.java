package com.example.msproductcatalog.mapper;

import com.example.msproductcatalog.dao.entity.BasketEntity;
import com.example.msproductcatalog.dao.entity.OrderDetailsEntity;
import com.example.msproductcatalog.model.request.OrderDetailsRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDetailsMapper {
    OrderDetailsMapper INSTANCE = Mappers.getMapper(OrderDetailsMapper.class);
    default OrderDetailsEntity mapRequestToEntity(OrderDetailsRequest orderDetails, BasketEntity basket){
        return OrderDetailsEntity.builder().
                customerName(orderDetails.getCustomerName()).
                customerAddress(orderDetails.getCustomerAddress()).
                basket(basket).
                build();
    }
}
