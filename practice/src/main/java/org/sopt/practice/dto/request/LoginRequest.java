package org.sopt.practice.dto.request;

public record LoginRequest(
        String username,
        String password
) {
}
