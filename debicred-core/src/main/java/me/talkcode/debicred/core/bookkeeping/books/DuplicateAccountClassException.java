package me.talkcode.debicred.core.bookkeeping.books;

import me.talkcode.debicred.core.AccountingException;

public class DuplicateAccountClassException extends AccountingException {

    public DuplicateAccountClassException(String id) {
        super("There is already an Account class with ID=" + id);
    }
    
}
