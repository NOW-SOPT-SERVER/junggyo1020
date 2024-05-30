package org.sopt.practice.exception.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.sopt.practice.exception.enums.SuccessMessage;

public record SuccessResponse<T>(
        int status,
        String message,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        T data
) {
    public static <T> SuccessResponse of(SuccessMessage successMessage){
        return new SuccessResponse(successMessage.getStatus(), successMessage.getMessage(), null);
    }

    public static <T> SuccessResponse of(SuccessMessage successMessage, T data){
        return new SuccessResponse(successMessage.getStatus(), successMessage.getMessage(), data);
    }
}
