package com.schefen.forumserver.entities.requests.category;

import lombok.Data;

@Data
public class CategoryUpdateRequest {
    private long categoryId;
    private String categoryName;
}
