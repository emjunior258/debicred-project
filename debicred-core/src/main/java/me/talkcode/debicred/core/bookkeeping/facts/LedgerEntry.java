package me.talkcode.debicred.core.bookkeeping.facts;

import me.talkcode.debicred.core.bookkeeping.model.Account;
import me.talkcode.debicred.core.bookkeeping.model.AccountClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.talkcode.debicred.core.AccountingException;
import me.talkcode.debicred.core.bookkeeping.books.Ledger;
import me.talkcode.debicred.core.bookkeeping.books.LedgerAddress;
import me.talkcode.debicred.core.bookkeeping.books.LedgerRecord;
import me.talkcode.debicred.core.bookkeeping.model.Amount;

import java.time.LocalDate;

/**
 * Represents an entry in the {@link Ledger}.
 */
public class LedgerEntry {
    
    private LedgerAddress accountAddress;
    private Amount amount;
    private Ledger.EntryType type;

    private static final Logger LOGGER = LogManager.getLogger(LedgerEntry.class);

    public LedgerEntry(LedgerAddress accountAddress, Amount amount, Ledger.EntryType type) {
        if(accountAddress == null)
            throw new IllegalArgumentException("accountAddress must not be null");
        if(amount == null)
            throw new IllegalArgumentException("amount must not be null");
        if(type == null)
            throw new IllegalArgumentException("entry type must not be null");
        this.accountAddress = accountAddress;
        this.amount = amount;
        this.type = type;
    }

    public LedgerAddress getAccountAddress() {
        return this.accountAddress;
    }

    public Amount getAmount() {
        return this.amount;
    }

    public Ledger.EntryType getType() {
        return this.type;
    }

    public AccountEntry post(Ledger ledger, LocalDate date) {
        if(ledger==null)
            throw new IllegalArgumentException("ledger must not be null");
        if(date==null)
            throw new IllegalArgumentException("date must not be null");
        var record = this.getRecord(ledger);
        if(record instanceof AccountClass)
            throw new AccountingException("address must point to a record of type Account: " + accountAddress);
        var account = (Account) record;
        if(account.hasChildren())
            throw new AccountingException("address must point to a record that is a leaf Account: " + accountAddress);
        return account.postEntry(type, amount, date);
    }

    private LedgerRecord getRecord(Ledger ledger) {
        //TODO: Implementation
        throw new UnsupportedOperationException();
    }

}
