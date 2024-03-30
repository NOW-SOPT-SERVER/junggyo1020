package org.sopt.practice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter //Getter가 없으면 데이터에 접근할 수 없어서 통신이 불가능하다.
public class ApiResponse {
    private String content;

    public static ApiResponse create(String content){
        return new ApiResponse(content);
    }
}
