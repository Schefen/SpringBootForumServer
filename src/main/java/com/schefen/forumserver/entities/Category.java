package com.schefen.forumserver.entities;

import com.schefen.forumserver.entities.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)

public class Category extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long categoryId;
    private LocalDate createdDate;
    private String categoryName;

    @ManyToMany(mappedBy = "categories")
    private Set<Content> contents = new HashSet<>();
}
