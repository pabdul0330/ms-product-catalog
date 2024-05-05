package com.example.msproductcatalog.mapper;

import com.example.msproductcatalog.dao.entity.CategoryEntity;
import com.example.msproductcatalog.dao.entity.ProductEntity;
import com.example.msproductcatalog.model.request.CategoryRequest;
import com.example.msproductcatalog.model.request.ProductRequest;
import com.example.msproductcatalog.model.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "category.id", source = "categoryId")
    ProductEntity mapRequestToEntity(ProductRequest request);

    @Mappings({
            @Mapping(target = "category.categoryName", source = "entity.category.categoryName")
    })
    ProductResponse entityToResponse(ProductEntity entity);

    //    CategoryRequest categoryEntityToRequest(ProductEntity entity);
    List<ProductResponse> mapEntityListToResponseList(List<ProductEntity> entity);

    ProductResponse requestToResponse(ProductRequest request);

    @Mapping(target = "entity.category", source = "category")
    @Mapping(source = "id", target = "entity.id")
    void editProduct(@MappingTarget ProductEntity entity,
                     CategoryEntity category,
                     Long id,
                     ProductRequest request);

//   default ProductEntity mapRequestToEntity(ProductEntity entity,
//                                     CategoryEntity categoryEntity,
//                                     ProductRequest request) {
//        return ProductEntity.builder()
//                .id(entity.getId())
//                .productName(request.getProductName())
//                .productCount()
//                .productDescription()
//                .productPrice()
//                .category(categoryEntity)
//                .build();
//    }

    default ProductEntity map(ProductEntity entity,
                                     CategoryEntity categoryEntity,
                                     ProductRequest request) {
       entity.setProductName(request.getProductName());

        return entity;
    }
}
