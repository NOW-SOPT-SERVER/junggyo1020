package org.sopt.seminar3.dto;

import org.sopt.seminar3.domain.SuccessMessage;

public record SuccessStatusResponse(
        int status,
        String message
) {
    public static SuccessStatusResponse of(SuccessMessage successMessage){
        return new SuccessStatusResponse(successMessage.getStatus(), successMessage.getMessage());
    }
}
