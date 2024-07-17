package com.example.msproductcatalog.service;

import com.example.msproductcatalog.client.MailSenderClient;
import com.example.msproductcatalog.dao.entity.CategoryEntity;
import com.example.msproductcatalog.dao.repository.CategoryRepository;
import com.example.msproductcatalog.mapper.CategoryMapper;
import com.example.msproductcatalog.model.exception.NotFoundException;
import com.example.msproductcatalog.model.request.CategoryRequest;
import com.example.msproductcatalog.model.request.UserRequest;
import com.example.msproductcatalog.model.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final MailSenderClient mailSenderClient;

    public void addCategory(CategoryRequest categoryRequest) {
        categoryRepository.save(CategoryMapper.INSTANCE.mapRequestToEntity(categoryRequest));
    }


    public List<CategoryResponse> getCategories() {
        return CategoryMapper.INSTANCE.mapEntityListToResponseList(categoryRepository.findAll());
    }

    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

    public CategoryResponse getCategoryById(long id) {
        return CategoryMapper.INSTANCE.
                mapEntityToResponse(categoryRepository.findById(id).
                        orElseThrow(() -> new NotFoundException("Category not found.")));
    }

    public void editCategory(long id, CategoryRequest request) {
        CategoryEntity entity = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found."));
        CategoryMapper.INSTANCE.editCategory(entity, request);
        categoryRepository.save(entity);
    }

}
