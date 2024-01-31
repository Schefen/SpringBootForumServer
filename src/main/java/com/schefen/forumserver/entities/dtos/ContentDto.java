package com.schefen.forumserver.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ContentDto {
    private long contentId;
    private LocalDate createdDate;
    private String contentHeader;
    private String contentItself;
    private long userId;
    private Set<Long> categoryIds;
}
