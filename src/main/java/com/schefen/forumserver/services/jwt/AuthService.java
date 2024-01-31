package com.schefen.forumserver.services.jwt;

import com.schefen.forumserver.entities.jwt.User;
import com.schefen.forumserver.aspect.UserRole;
import com.schefen.forumserver.repositories.JWT.UserRepository;
import com.schefen.forumserver.services.jwt.utils.AuthResponse;
import com.schefen.forumserver.services.jwt.utils.LoginRequest;
import com.schefen.forumserver.services.jwt.utils.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .birthDate(registerRequest.getBirthDate())
                .email(registerRequest.getEmail())
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(UserRole.USER)
                .build();

        User savedUser = userRepository.save(user);
        var accessToken = jwtService.generateToken(savedUser);
        var refreshToken = refreshTokenService.createRefreshToken(savedUser.getEmail());

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken.getRefreshToken())
                .build();
    }
public AuthResponse login(LoginRequest loginRequest) {
    try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
    } catch (AuthenticationException e) {
        throw new BadCredentialsException("Invalid email or password");
    }

    var user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    var accessToken = jwtService.generateToken(user);
    var refreshToken = refreshTokenService.createRefreshToken(loginRequest.getEmail());

    return AuthResponse.builder()
            .accessToken(accessToken)
            .refreshToken(refreshToken.getRefreshToken())
            .build();
}
}
