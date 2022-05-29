package me.talkcode.debicred.core;

public class ConcurrentPeriodException extends AccountingViolationException {

    public ConcurrentPeriodException() {
        super("There is already an ongoing Accounting period and ");
    }
}
