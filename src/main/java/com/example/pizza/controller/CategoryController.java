package com.example.pizza.controller;

import com.example.pizza.enums.DeleteMode;
import com.example.pizza.request.category.CategoryCreateRequest;
import com.example.pizza.request.category.CategoryUpdateRequest;
import com.example.pizza.response.CategoryResponse;
import com.example.pizza.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> categoryResponses = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id) {
        CategoryResponse categoryResponse = categoryService.getCategoryById(id);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryCreateRequest categoryCreateRequest) {
        CategoryResponse categoryResponse = categoryService.create(categoryCreateRequest);
        return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id,
                                                   @RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        CategoryResponse categoryResponse = categoryService.update(id, categoryUpdateRequest);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponse> delete(@PathVariable Long id,
                                                   @RequestParam(value = "deleteMode", defaultValue = "SOFT")
                                                   DeleteMode deleteMode) {
        CategoryResponse categoryResponse = categoryService.deleteById(id, deleteMode);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }
}
