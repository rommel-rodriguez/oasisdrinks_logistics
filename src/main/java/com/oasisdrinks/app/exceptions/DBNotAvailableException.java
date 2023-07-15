/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.exceptions;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class DBNotAvailableException extends DataAccessException {
    
    public DBNotAvailableException(String message) {
        super(message);
    }

    public DBNotAvailableException (String message, Throwable cause) {
        super(message, cause);
    }
    
}
