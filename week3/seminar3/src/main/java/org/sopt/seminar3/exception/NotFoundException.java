package org.sopt.seminar3.exception;

import org.sopt.seminar3.exception.message.ErrorMessage;

public class NotFoundException extends BusinessException{
    public NotFoundException(ErrorMessage errorMessage){
        super(errorMessage);
    }
}
