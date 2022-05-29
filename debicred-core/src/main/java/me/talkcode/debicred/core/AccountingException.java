package me.talkcode.debicred.core;

public class AccountingException extends RuntimeException {

    public AccountingException(String message){
        super(message);
    }

    public AccountingException(String message, Throwable cause){
        super(message, cause);
    }
    
}
