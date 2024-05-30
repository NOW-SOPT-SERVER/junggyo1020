package org.sopt.practice.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessMessage {
    BLOG_CREATE_SUCCESS(HttpStatus.CREATED.value(), "블로그 POST API 성공."),
    POST_CREATE_SUCCESS(HttpStatus.CREATED.value(), "게시글 POST API 성공"),
    POST_GET_SUCCESS(HttpStatus.OK.value(), "게시글 GET API 성공."),
    ;

    private final int status;
    private final String message;

}
