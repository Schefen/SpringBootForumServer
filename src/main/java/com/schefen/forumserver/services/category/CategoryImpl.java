package com.schefen.forumserver.services.category;

import com.schefen.forumserver.entities.Category;
import com.schefen.forumserver.entities.dtos.AuthorDto;
import com.schefen.forumserver.entities.dtos.CategoryDto;
import com.schefen.forumserver.entities.requests.category.CategoryCreateRequest;
import com.schefen.forumserver.entities.requests.category.CategoryUpdateRequest;
import com.schefen.forumserver.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(category -> modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
    }
    @Override
    public CategoryDto getById(long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return modelMapper.map(category, CategoryDto.class);
    }
    @Override
    public CategoryDto createCategory(CategoryCreateRequest categoryCreateRequest) {
        Category category = modelMapper.map(categoryCreateRequest, Category.class);
        category = categoryRepository.save(category);
        return modelMapper.map(category,CategoryDto.class);
    }
    @Override
    public void updateCategory(CategoryUpdateRequest updateRequest) throws Exception {
        Optional<Category> category = categoryRepository.findById(updateRequest.getCategoryId());
        if (category.isPresent()){
            Category existingCategory = category.get();
            existingCategory.setCategoryName(updateRequest.getCategoryName());
            Category updatedCategory = categoryRepository.save(existingCategory);
        }
        else throw new Exception("Hata..");
    }
}
