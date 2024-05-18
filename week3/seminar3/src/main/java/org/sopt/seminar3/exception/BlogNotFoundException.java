package org.sopt.seminar3.exception;

import org.sopt.seminar3.exception.message.ErrorMessage;

public class BlogNotFoundException extends BusinessException {
    public BlogNotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
