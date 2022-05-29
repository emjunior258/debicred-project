package me.talkcode.debicred.core.bookkeeping.model;

import java.time.LocalDate;
import java.util.Optional;

import me.talkcode.debicred.core.AccountingViolationException;
import me.talkcode.debicred.core.bookkeeping.facts.AccountEntry;
import me.talkcode.debicred.core.bookkeeping.books.Ledger;
import me.talkcode.debicred.core.bookkeeping.books.LedgerRecord;
import me.talkcode.commons.query.Queryable;


/**
 * A record in the accounting system that tracks the financial activities of one or more asset, liability, equity, revenue, or expense.
 * 
 * An account may have children and whenever it has children you cannot perform debits nor credits directly on it.
 * Whenever an account has children, the balance it shows is sum of the balance of all it's children.
 * Whenever an account is sealed, you can no longer add child accounts to it.
 */
public interface Account extends LedgerRecord {

    /**
     * Gets the nature of the account.
     * @return
     */
    AccountNature getNature();

    /**
     * Posts an entry into the account.
     * @param type the {@link Ledger.EntryType}
     * @param amount the amount of the entry
     * @param date the balance date
     * @return the posted {@link AccountEntry}.
     * @throws AccountingViolationException when trying to perform a post onto an {@link Account} that has child {@link Account}s. Posts may only be performed on accounts without children
     */
    AccountEntry postEntry(Ledger.EntryType type, Amount amount, LocalDate date) throws AccountingViolationException;

    /**
     * Gets the account's balance.
     * @return the account's own balance in case it has no children, otherwise it returns the sum of the balance of all children.
     */
    Amount getBalance();


    /**
     * Blocks any further attemps of adding children accounts.
     */
    void seal();


    /**
     * Tells whether the account is selead or not.
     * @return true if the account is sealed, false otherwise.
     */
    boolean isSealed();

    /**
     * Adds a child account. The account will have the same nature and category of the parent account.
     * @param id the unique identifier of the account.
     * @param name the name to be assigned to be account.
     * @return the instance of the newly created account.
     * @throws SealedAccountException when attempting to add a child account after sealing the account.
     * @throws DuplicateAccountException when attempting to add a child account with an ID that is already being used by another account.
     */
    Account addChild(String id, String name) throws SealedAccountException, DuplicateAccountException;


    /**
     * Checks whether account has any children accounts.
     * @return true if the account has at least one child, false if doesn't have any.
     */
    boolean hasChildren();


    /**
     * Gets the count of child accounts.
     * @return the total count of child accounts that this account has. The number doesn't include the children of the child accounts.
     */
    long getChildrenCount();

    /**
     * Gets a Queryable instance to query children accounts
     * @return a Queryable instance if the account has children
     */
    Optional<Queryable<Account>> children();


    /**
     * Gets a Queryable instance to query entries
     * @return a Queryable instance
     */
    Queryable<AccountEntry> entries();

}