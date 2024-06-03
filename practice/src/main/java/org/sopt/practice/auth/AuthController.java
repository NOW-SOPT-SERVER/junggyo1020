package org.sopt.practice.auth;

import lombok.RequiredArgsConstructor;
import org.sopt.practice.dto.request.LoginRequest;
import org.sopt.practice.dto.request.RefreshTokenRequest;
import org.sopt.practice.dto.response.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest loginRequest
    ){
        LoginResponse loginResponse = authService.login(loginRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(loginResponse);
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refresh(
            @RequestBody RefreshTokenRequest refreshTokenRequest
    ){
        LoginResponse loginResponse = authService.refreshAccessToken(refreshTokenRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(loginResponse);
    }
}
