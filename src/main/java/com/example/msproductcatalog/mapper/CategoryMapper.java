package com.example.msproductcatalog.mapper;

import com.example.msproductcatalog.dao.entity.CategoryEntity;
import com.example.msproductcatalog.model.request.CategoryRequest;
import com.example.msproductcatalog.model.response.CategoryResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE= Mappers.getMapper(CategoryMapper.class);
    CategoryEntity mapRequestToEntity(CategoryRequest request);
    CategoryResponse mapEntityToResponse(CategoryEntity entity);
    List<CategoryResponse> mapEntityListToResponseList(List<CategoryEntity> entities);
    void editCategory(@MappingTarget CategoryEntity entity, CategoryRequest request);
}
