package me.talkcode.debicred.core.bookkeeping.facts;

import me.talkcode.debicred.core.AccountingException;

public class UnbalancedTransactionException extends AccountingException {

    public UnbalancedTransactionException() {
        super("The transaction credit amount doesn't balance with debit amount");
    }


}
