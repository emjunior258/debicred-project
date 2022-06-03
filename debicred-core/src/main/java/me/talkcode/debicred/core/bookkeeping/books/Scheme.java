package me.talkcode.debicred.core.bookkeeping.books;

import me.talkcode.debicred.core.bookkeeping.model.Account;
import me.talkcode.debicred.core.bookkeeping.model.AccountClass;

/**
 * Defines the structure of the Accounting {@link Ledger}, more specifically the structure of {@link AccountClass}s and {@link Account}s.
 * 
 * Each scheme provides a different structure of {@link AccountClass}ess and {@link Account}s.
 * The idea is of a scheme is to configure accounting, according to the organization needs and or regulations.
 *
 * Many schemes can be developed and used for different
 */
public interface Scheme {

    /**
     * Gets the unique identifier of the scheme.
     * @return the unique identifier of the scheme
     */
    String getId();

    /**
     * Gets the description of the accounting scheme.
     * @return the description of the scheme
     */
    String getDescription();

    /**
     * Initializes a Ledger with the accounting scheme structure
     * @param ledger the ledger to be initialized
     */
    void initialize(Ledger ledger);
}
