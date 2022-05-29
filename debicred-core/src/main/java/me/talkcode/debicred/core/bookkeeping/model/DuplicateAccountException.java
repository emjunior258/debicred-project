package me.talkcode.debicred.core.bookkeeping.model;

import me.talkcode.debicred.core.bookkeeping.books.LedgerException;

public class DuplicateAccountException extends LedgerException {

    public DuplicateAccountException(String id) {
        super("There is already an Account with ID=" + id);
    }
    
}
