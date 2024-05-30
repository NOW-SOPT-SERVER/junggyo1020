package org.sopt.practice.dto.request;

import org.sopt.practice.domain.enums.Part;

public record MemberCreateDto(
        String name,
        Part part,
        int age
) {
}
