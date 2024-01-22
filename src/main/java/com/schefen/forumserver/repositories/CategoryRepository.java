package com.schefen.forumserver.repositories;

import com.schefen.forumserver.entities.Category;
import com.schefen.forumserver.entities.dtos.CategoryDto;
import com.schefen.forumserver.entities.requests.category.CategoryUpdateRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Modifying
    @Query("Update Category c set c.categoryName = ?1 where c.categoryId =?2")
    CategoryDto updateCategory(String categoryName, long categoryId);
}
