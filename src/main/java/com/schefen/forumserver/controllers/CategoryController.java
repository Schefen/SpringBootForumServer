package com.schefen.forumserver.controllers;

import com.schefen.forumserver.aspect.Authorize;
import com.schefen.forumserver.entities.dtos.CategoryDto;
import com.schefen.forumserver.entities.requests.category.CategoryCreateRequest;
import com.schefen.forumserver.entities.requests.category.CategoryUpdateRequest;
import com.schefen.forumserver.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Authorize("USER")
    @GetMapping("/get-all")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getCategories());
    }
    @GetMapping("/get-by-id/{id}")
    @Authorize("ADMIN")
    public ResponseEntity<CategoryDto> getById(long id){
        return ResponseEntity.ok(categoryService.getById(id));
    }
    @Authorize("ADMIN")
    @PutMapping("/edit-category")
    public ResponseEntity<String> updateCategory(@RequestBody CategoryUpdateRequest updateRequest) throws Exception {
        categoryService.updateCategory(updateRequest);
        return ResponseEntity.ok("Success");
    }
    @Authorize("ADMIN")
    @PostMapping("/add-category")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryCreateRequest createRequest){
        return ResponseEntity.ok(categoryService.createCategory(createRequest));
    }

 }
