package com.example.msproductcatalog.controller;

import com.example.msproductcatalog.model.request.CategoryRequest;
import com.example.msproductcatalog.model.response.CategoryResponse;
import com.example.msproductcatalog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public void addCategory(@RequestBody CategoryRequest request) {
        categoryService.addCategory(request);
    }

    @GetMapping
    public List<CategoryResponse> getCategories() {
        return categoryService.getCategories();
    }

    @DeleteMapping("delete/{id}")
    public void deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
    }

    @PutMapping("edit/{id}")
    public void editCategory(@PathVariable long id, @RequestBody CategoryRequest request) {
        categoryService.editCategory(id, request);
    }

    @GetMapping("find/{id}")
    public CategoryResponse findCategoryById(@PathVariable long id) {
        return categoryService.getCategoryById(id);
    }
}
