package org.sopt.practice.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    MEMBER_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
    BLOG_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 블로그가 존재하지 않습니다."),
    MEMBER_NOT_OWNED_BLOG_EXCEPTION(HttpStatus.NOT_FOUND.value(), "블로그 소유자가 아닙니다."),
    POST_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(),  "ID에 해당하는 게시글이 존재하지 않습니다."),
    JWT_UNAUTHORIZED_EXCEPTION(HttpStatus.UNAUTHORIZED.value(), "사용자의 로그인 검증을 실패했습니다."),
    INVALID_MEMBER_PASSWORD_EXCEPTION(HttpStatus.BAD_REQUEST.value(), "비밀번호가 일치하지 않습니다."),
    INVALID_REFRESH_TOKEN_EXCEPTION(HttpStatus.BAD_REQUEST.value(), "Refresh 토큰이 존재하지 않습니다."),
    ;

    private final int status;
    private final String message;
}
