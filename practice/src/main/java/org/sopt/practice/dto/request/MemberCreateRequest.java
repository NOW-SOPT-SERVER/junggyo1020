package org.sopt.practice.dto.request;

import org.sopt.practice.domain.enums.Part;

public record MemberCreateRequest(
        String username,
        String password,
        Part part,
        int age
) {
}
