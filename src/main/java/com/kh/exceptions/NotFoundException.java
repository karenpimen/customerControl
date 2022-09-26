package com.kh.exceptions;

public class NotFoundException extends RuntimeException{
    String message;
    public NotFoundException(){}
    public NotFoundException(String mess){
        this.message = message;
    }

}
