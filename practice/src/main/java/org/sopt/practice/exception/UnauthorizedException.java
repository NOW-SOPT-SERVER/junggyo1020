package org.sopt.practice.exception;

import org.sopt.practice.exception.enums.ErrorMessage;

public class UnauthorizedException extends BusinessException{

    public UnauthorizedException(ErrorMessage errorMessage){
        super(errorMessage);
    }
}
