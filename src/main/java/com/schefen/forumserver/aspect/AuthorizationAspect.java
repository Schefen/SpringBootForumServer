package com.schefen.forumserver.aspect;

import com.schefen.forumserver.repositories.JWT.UserRepository;
import com.schefen.forumserver.services.jwt.JwtService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.file.AccessDeniedException;

@Aspect
@Component
public class AuthorizationAspect {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRepository userRepository;

    public AuthorizationAspect(JwtService jwtService,UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }
    @Before("@annotation(com.schefen.forumserver.aspect.Authorize) && execution(* com.schefen.forumserver.controllers.*.*(..))")    public void authorize() throws AccessDeniedException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails) principal;
            String username = userDetails.getUsername();
            String role = userRepository.findRoleByUsername(username);

            if (!"ADMIN".equals(role)) {
                throw new AccessDeniedException("Bu işlem yalnızca admin tarafından gerçekleştirilebilir.");
            }
        }
    }
}