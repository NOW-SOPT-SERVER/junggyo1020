package org.sopt.clonecoding.web.dto;

public record ProductCreateDto(
        Long memberId,
        String title,
        boolean isSale,
        int price,
        String description,
        String address
) {
}
