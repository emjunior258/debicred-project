package me.talkcode.debicred.core;

public class NoActiveContextException extends AccountingException {

    public NoActiveContextException() {
        super("There is no active accounting context");
    }


    
}
