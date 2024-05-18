package org.sopt.seminar3.dto;

import org.sopt.seminar3.domain.Part;

public record MemberCreateDto(
        String name,
        Part part,
        int age
) {
}
