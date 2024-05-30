package org.sopt.practice.dto.request;

public record BlogCreateRequest(
        String title,
        String description
) {
}
