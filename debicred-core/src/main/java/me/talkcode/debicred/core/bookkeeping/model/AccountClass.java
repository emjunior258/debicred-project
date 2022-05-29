package me.talkcode.debicred.core.bookkeeping.model;


import me.talkcode.debicred.core.bookkeeping.books.LedgerRecord;
import me.talkcode.commons.query.Queryable;

/**
 * Holds {@link Account}s of the same category.
 * Every account belongs to an account class.
 */
public interface AccountClass extends LedgerRecord {

    Queryable<Account> asQueryable();
    Account addAccount(String id, String name, AccountNature nature);

}
