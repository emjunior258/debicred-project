package me.talkcode.debicred.core.bookkeeping.model;

import me.talkcode.debicred.core.AccountingException;

public class SealedAccountException extends AccountingException {

    public SealedAccountException(Account account) {
        super(String.format("Account with ID=%s is sealed", account.getId()));
    }

}
