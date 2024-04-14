package com.sopt.practice2.Web.dto;

import com.sopt.practice2.domain.Part;

public record MemberCreateDto(String name, Part part, int age) {
}
