package com.umc.week6.exception;

public class NotFoundException extends BusinessException{
    public NotFoundException(ErrorCode errorCode){
        super(errorCode);
    };
}
