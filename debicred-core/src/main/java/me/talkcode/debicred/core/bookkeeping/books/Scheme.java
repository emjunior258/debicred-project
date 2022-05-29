package me.talkcode.debicred.core.bookkeeping.books;

import me.talkcode.debicred.core.bookkeeping.model.Account;
import me.talkcode.debicred.core.bookkeeping.model.AccountClass;
import me.talkcode.debicred.core.bookkeeping.model.AccountingPeriod;

/**
 * Defines the structure of the Accounting {@link Ledger}, more specifically the structure of {@link AccountClass}s and {@link Account}s.
 * 
 * Each scheme provides a different structure of {@link AccountClass}ess and {@link Account}s.
 * The idea is of a scheme is to configure accounting, according to the organization needs and or regulations.
 *
 * Many schemes can be developed and used for different
 */
public interface Scheme {

    String getId();
    String getDescription();
    void initialize(AccountingPeriod newPeriod, AccountingPeriod previousPeriod);
    void endYear(AccountingPeriod year);

}
