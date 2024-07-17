package com.example.msproductcatalog.controller;

import com.example.msproductcatalog.dao.entity.ProductEntity;
import com.example.msproductcatalog.model.request.ProductCriteriaRequest;
import com.example.msproductcatalog.model.request.ProductRequest;
import com.example.msproductcatalog.model.response.ProductResponse;
import com.example.msproductcatalog.service.ProductService;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
@Validated
public class ProductController {
    private final ProductService productService;
//
//    @PostMapping("/add")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addProduct(@Valid @RequestBody ProductRequest request) {
//        productService.addProduct(request);
//    }

//    @GetMapping
//    public List<ProductResponse> getProducts() {
//        return productService.getProducts();
//    }

    @PutMapping("edit/{id}")
    public void editProduct(@Valid @PathVariable long id, @RequestBody ProductRequest request) {
        productService.editProduct(id, request);
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@Valid @PathVariable long id) {
        productService.deleteProduct(id);
    }

//    @GetMapping("find/{id}")
//    public void findProduct(@Valid @PathVariable long id) {
//        productService.getProductById(id);
//    }

    @PostMapping(value = "/add")
    public void addProduct(@RequestBody ProductRequest productRequest) throws IOException {
        productService.addProduct(productRequest);

    }

//    @ApiOperation("Adding photo by productId")
//    @PostMapping(value = "/addPhoto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    @PreAuthorize("hasRole('SUPERUSER')")
//    public void addProductPhoto(@RequestParam Long id, @RequestParam MultipartFile photo) throws IOException {
//        productService.addProductPhoto(id, photo);
//    }

    @GetMapping
    public Page<ProductResponse> getProducts(ProductCriteriaRequest request,//ProductCriteria criteria
                                             @PageableDefault(size = 10)
                                             @SortDefault.SortDefaults({
                                                     @SortDefault(sort = "productPrice", direction = Sort.Direction.ASC)}) Pageable pageable) {
        return productService.getProducts(request, pageable);
    }
}

//    public Map<String, Object> getProducts(
//            @PageableDefault(size = 10)
//            @SortDefault.SortDefaults({
//                    @SortDefault(sort = "name", direction = Sort.Direction.ASC)
//            }) Pageable pageable) {
//
//
//    }
