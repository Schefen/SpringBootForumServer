package com.schefen.forumserver.services.jwt.utils;

import lombok.Data;

@Data
public class RefreshTokenRequest {
    private String refreshToken;
}
