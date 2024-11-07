package com.nttdata.bankaccountmanagementsystem.exceptions;

/**
 * Custom exception class that represents a business-related error in the
 * Bank Account Management System. It extends {@link RuntimeException} to
 * signal an error that occurs during the execution of business logic.
 *
 * <p>
 * This exception is used to handle and communicate specific business rule
 * violations or exceptional situations that arise during the operation of
 * the system.
 * </p>
 */
public class BusinessException extends RuntimeException{

    /**
     * Constructs a new {@link BusinessException} with the specified detail message.
     *
     * @param message The detail message that explains the reason for the exception.
     */
    public BusinessException(String message) {
        super(message);
    }
}
