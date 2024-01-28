package com.schefen.forumserver.entities;

import com.schefen.forumserver.entities.jwt.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="comments")
@EqualsAndHashCode(callSuper = false)
public class Comment extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long commentId;
    private LocalDate createdDate;
    private String commentItself;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name= "content_id")
    private Content content;
}
