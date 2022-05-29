package me.talkcode.debicred.core.bookkeeping.books;

import me.talkcode.debicred.core.AccountingException;

public class LedgerException extends AccountingException {


    public LedgerException(String message) {
        super(message);
    }

    public LedgerException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
