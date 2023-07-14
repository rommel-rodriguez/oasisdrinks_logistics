/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.exceptions;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class SQLDataAccessException extends DataAccessException {
    
    public SQLDataAccessException(String message) {
        super(message);
    }

    public SQLDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
