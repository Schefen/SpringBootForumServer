package com.schefen.forumserver.services.category;

import com.schefen.forumserver.entities.Category;
import com.schefen.forumserver.entities.dtos.CategoryDto;
import com.schefen.forumserver.entities.requests.category.CategoryCreateRequest;
import com.schefen.forumserver.entities.requests.category.CategoryUpdateRequest;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategories();

    CategoryDto getById(long id);

    CategoryDto createCategory(CategoryCreateRequest createRequest);
    void updateCategory(CategoryUpdateRequest updateRequest) throws Exception;
}
