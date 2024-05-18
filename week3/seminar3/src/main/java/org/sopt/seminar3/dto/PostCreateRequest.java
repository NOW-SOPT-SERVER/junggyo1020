package org.sopt.seminar3.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PostCreateRequest(
        @Size(max=20, message = "블로그 제목이 너무 길어요.")
        @NotBlank String title,
        @Size(max=500, message = "블로그 내용이 너무 길어요.")
        @NotBlank String content
){
}
