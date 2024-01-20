package com.schefen.forumserver.repositories;

import com.schefen.forumserver.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
