package com.sd.ecommerce.controller;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.ecommerce.model.ProductCategory;
import com.sd.ecommerce.model.Response;
import com.sd.ecommerce.service.ProductCategoryService;

import lombok.RequiredArgsConstructor;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

import java.util.Map;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class ProductCategoryController {
    
    private final ProductCategoryService productCategoryService;

    @PostMapping("/create")
    public ResponseEntity<Response> createProductCategory(@RequestBody @NotNull ProductCategory productCategory) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("productCategory", productCategoryService.save(productCategory)))
            .message("Product Category created")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @GetMapping("/list")
    public ResponseEntity<Response> listProductCategories() {
    return ResponseEntity.ok(
        Response.builder()
        .timeStamp(now())
        .data(Map.of("productCategories", productCategoryService.list()))
        .message("Product Categories retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
    );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getProductCategory(@NotNull Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("productCategory", productCategoryService.get(id)))
            .message("Product Category retrieved")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateProductCategory(@NotNull Long id, @RequestBody @NotNull ProductCategory productCategory) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("productCategory", productCategoryService.update(id, productCategory)))
            .message("Product Category updated")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteProductCategory(@NotNull Long id) {
        return ResponseEntity.ok(
            Response.builder()
            .timeStamp(now())
            .data(Map.of("productCategory", productCategoryService.delete(id)))
            .message("Product Category deleted")
            .status(OK)
            .statusCode(OK.value())
            .build()
        );
    }
}