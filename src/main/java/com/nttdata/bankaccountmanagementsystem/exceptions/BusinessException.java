package com.nttdata.bankaccountmanagementsystem.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
