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
public class Content extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long contentId;
    private LocalDate createdDate;
    private String contentHeader;
    private String contentItself;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "authorId")
    private Author author;

    @ManyToMany     //One content can have several category
    @JoinTable(
            name = "content_category",
            joinColumns = @JoinColumn(name="content_id"),
            inverseJoinColumns = @JoinColumn(name="category_id")
    )
    private Set<Category> categories = new HashSet<>();

}
