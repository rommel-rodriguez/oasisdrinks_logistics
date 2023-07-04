package com.oasisdrinks.app.models;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 * @param <T>
 */
@FunctionalInterface
public interface ComputeTotal<T>{
    double apply(T t1);
}
