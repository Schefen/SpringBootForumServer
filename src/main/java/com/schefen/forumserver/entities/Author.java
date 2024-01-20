package com.schefen.forumserver.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorId;
    private LocalDate createdDate;
    private String authorFirstName;
    private String authorLastName;
    private String authorNickName;
    private String authorEmail;
    private String authorImage;
    private String authorPhoneNumber;
    private String authorAge;
    private String authorPassword;
    private boolean authorStatus;

}
