package org.sopt.seminar3.common.dto;

import org.sopt.seminar3.domain.SuccessMessage;

public record SuccessResponse(
        int status,
        String message
) {
    public static SuccessResponse of(SuccessMessage successMessage){
        return new SuccessResponse(successMessage.getStatus(), successMessage.getMessage());
    }
}
