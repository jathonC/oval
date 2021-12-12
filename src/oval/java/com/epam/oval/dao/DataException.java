package com.epam.oval.dao;

public class DataException extends Exception{
    public DataException(String message,Exception e){
        super(message);
    }
}
