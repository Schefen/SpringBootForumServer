package com.schefen.forumserver.controllers;

import com.schefen.forumserver.entities.dtos.CategoryDto;
import com.schefen.forumserver.entities.requests.category.CategoryCreateRequest;
import com.schefen.forumserver.entities.requests.category.CategoryUpdateRequest;
import com.schefen.forumserver.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/get-all")
    public List<CategoryDto> getAllCategories(){
        return categoryService.getCategories();
    }
    @GetMapping("/get-by-id/{id}")
    public CategoryDto getById(long id){
        return categoryService.getById(id);
    }
    @PutMapping("/edit-category")
    public void updateCategory(@RequestBody CategoryUpdateRequest updateRequest) throws Exception {
        categoryService.updateCategory(updateRequest);
    }
    @PostMapping("/add-category")
    public CategoryDto createCategory(@RequestBody CategoryCreateRequest createRequest){
        return categoryService.createCategory(createRequest);
    }

 }
