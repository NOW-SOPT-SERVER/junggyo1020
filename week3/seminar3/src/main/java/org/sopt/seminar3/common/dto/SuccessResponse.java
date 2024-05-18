package org.sopt.seminar3.common.dto;

import org.sopt.seminar3.domain.SuccessMessage;

public record SuccessResponse<T>(
        int status,
        String message,
        T data
) {
    public static SuccessResponse of(SuccessMessage successMessage){
        return new SuccessResponse(successMessage.getStatus(), successMessage.getMessage(),null);
    }
    public static <T> SuccessResponse<T> of(SuccessMessage successMessage, T data) {
        return new SuccessResponse<>(successMessage.getStatus(), successMessage.getMessage(), data);
    }
}
