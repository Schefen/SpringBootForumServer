package com.schefen.forumserver.entities.jwt;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tokenId;

    @Column(nullable = false, length = 500)
    private String refreshToken;

    @Column(nullable = false)
    private Instant expirationTime;

    @OneToOne
    private User user;
}
