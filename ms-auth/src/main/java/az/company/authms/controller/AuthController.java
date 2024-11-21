package az.company.authms.controller;

import az.company.authms.model.dto.UserLoginRequest;
import az.company.authms.model.dto.UserRegisterRequest;
import az.company.authms.model.dto.UserRegisterResponse;
import az.company.authms.model.dto.token.TokenResponse;
import az.company.authms.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@Valid @RequestBody UserRegisterRequest userRequest) {
        return ResponseEntity.ok(authService.register(userRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(authService.loginUser(request));
    }
}
