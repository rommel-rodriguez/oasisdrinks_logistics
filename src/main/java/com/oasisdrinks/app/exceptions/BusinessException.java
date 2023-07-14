/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.exceptions;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class BusinessException extends Exception {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
    
    // Inner class for specific business rule violation: UserNotFoundException
    public static class UserNotFoundException extends BusinessException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
    
    public static class DuplicateUserException extends BusinessException {
        public DuplicateUserException(String message) {
            super(message);
        }
    }
    
    public static class InsufficientBalanceException extends BusinessException {
        public InsufficientBalanceException(String message) {
            super(message);
        }
    }
}
