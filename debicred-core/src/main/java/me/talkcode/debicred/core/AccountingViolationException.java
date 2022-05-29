package me.talkcode.debicred.core;


/**
 * Thrown when there was an attempt to violate an accounting rule.
 */
public class AccountingViolationException extends AccountingException {

    public AccountingViolationException(String message) {
        super(message);
    }
    
}
