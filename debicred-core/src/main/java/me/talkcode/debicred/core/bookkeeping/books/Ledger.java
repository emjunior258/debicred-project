package me.talkcode.debicred.core.bookkeeping.books;

import me.talkcode.debicred.core.bookkeeping.Book;
import me.talkcode.debicred.core.bookkeeping.model.Account;
import me.talkcode.debicred.core.bookkeeping.model.AccountClass;
import me.talkcode.commons.query.Queryable;

import java.util.Optional;
import java.util.Set;

/**
 * A book that Contains the information that is required to prepare financial statements. 
 * 
 * The Ledger is organized in {@link LedgerRecord}s.
 * 
 * It includes {@link AccountClass}es and {@link Account}s for assets, liabilities, owners' equity, revenues and expenses.
 */
public interface Ledger extends Book {

    /**
    * Defines the type of entry that can be posted in a {@link Ledger} {@link Account}.
    */
    enum EntryType {
        Debit, Credit
    }
    
    /**
     * Gets a {@link LedgerRecord}
     * @param addr the address to the ledger record
     * @return the {@link LedgerRecord} that is stored under the provided address.
     */
    Optional<LedgerRecord> getRecord(LedgerAddress addr);

    /**
     * Gets information about the {@link LedgerRecord}.
     * @param addr the address of the {@link LedgerRecord}.
     * @return an empty {@link Optional} if the {@link LedgerRecord} is not found, otherwise the {@link LedgerRecordInfo} is returned.
     */
    Optional<LedgerRecordInfo> getRecordInfo(LedgerAddress addr);

    
    /**
     * Gets a handle to query {@link Account}s in the {@link Ledger}.
     * @return a {@link Queryable} to be used to query {@link Account}s in the {@link Ledger}.
     */
    Queryable<Account> getAccountsQueryable();


    /**
     * Gets the set of {@link AccountClass}ess that are part of the Ledger
     * @return the set of {@link AccountClass}ess added to the Ledger
     */
    Set<AccountClass> getClasses();


    /**
     * Adds a new {@link AccountClass} to the Ledger
     * @param id the unique identifier of the class
     * @param name the name of the class
     * @return the newly created instance of {@link AccountClass}
     * @throws DuplicateAccountClassException when there is already an {@link AccountClass} with the same ID.
     */
    AccountClass addAccountClass(String id, String name) throws DuplicateAccountClassException;

}
