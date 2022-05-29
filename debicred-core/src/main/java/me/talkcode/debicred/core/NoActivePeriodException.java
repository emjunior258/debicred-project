package me.talkcode.debicred.core;

public class NoActivePeriodException extends AccountingException {

    public NoActivePeriodException() {
        super("There is no accounting period active");
    }

}
