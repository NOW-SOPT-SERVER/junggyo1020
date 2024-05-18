package org.sopt.seminar3.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessMessage {

    BLOG_CREATE_SUCCESS(HttpStatus.CREATED.value(),"블로그 생성이 완료되었습니다."),
    POST_CREATE_SUCCESS(HttpStatus.CREATED.value(),"게시글 생성이 완료되었습니다."),
    POST_GET_SUCCESS(HttpStatus.OK.value(),"게시글 찾기가 완료되었습니다."),
    ;
    private final int status;
    private final String message;
}
