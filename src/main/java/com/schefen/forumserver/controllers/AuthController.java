package com.schefen.forumserver.controllers;

import com.schefen.forumserver.entities.jwt.RefreshToken;
import com.schefen.forumserver.entities.jwt.User;
import com.schefen.forumserver.services.jwt.AuthService;
import com.schefen.forumserver.services.jwt.JwtService;
import com.schefen.forumserver.services.jwt.RefreshTokenService;
import com.schefen.forumserver.services.jwt.utils.AuthResponse;
import com.schefen.forumserver.services.jwt.utils.LoginRequest;
import com.schefen.forumserver.services.jwt.utils.RefreshTokenRequest;
import com.schefen.forumserver.services.jwt.utils.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final AuthService authService;

    public AuthController(JwtService jwtService, RefreshTokenService refreshTokenService, AuthService authService) {
        this.jwtService = jwtService;
        this.refreshTokenService = refreshTokenService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authService.register(registerRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login (@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }
    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        RefreshToken refreshToken = refreshTokenService.verifyRefreshToken(refreshTokenRequest.getRefreshToken());
        User user = refreshToken.getUser();
        String accessToken = jwtService.generateToken(user);
        return ResponseEntity.ok(AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken.getRefreshToken())
                .build());
    }
}
