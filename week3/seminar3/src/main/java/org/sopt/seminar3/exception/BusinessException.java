package org.sopt.seminar3.exception;

import org.postgresql.util.ServerErrorMessage;
import org.sopt.seminar3.exception.message.ErrorMessage;

public class BusinessException extends RuntimeException{
    private ErrorMessage errorMessage;
    public BusinessException(ErrorMessage errorMessage){
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
