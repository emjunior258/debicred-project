package me.talkcode.debicred.core.bookkeeping.model;

import java.time.LocalDate;

import me.talkcode.debicred.core.bookkeeping.books.Journal;
import me.talkcode.debicred.core.bookkeeping.books.Ledger;
import me.talkcode.debicred.core.bookkeeping.books.Scheme;

/**
 * An accounting period, is a company’s financial reporting period.
 * 
 * The accounting period is typically a period of twelve months, however, this API leaves it open for any duration.
 * Organizations can choose to have their accounting period begin and end on any dates.
 */
public interface AccountingPeriod {

    /**
     * Gets the accounting Journal of the period.
     * @return {@link Journal} of the accounting period.
     */
    Journal getJournal();

    /**
     * Gets the accounting Ledger of the financial Journal.
     * @return {@link Ledger} of the accounting period.
     */
    Ledger getLedger();


    /**
     * Gets the date in which the accounting period started.
     * @return the date in which the accounting period started.
     */
    LocalDate getStart();

    /**
     * Gets the date in which the accounting period ended or ends.
     * @return the date in which the accounting period ended or ends.
     */
    LocalDate getEnd();

    /**
     * Gets the identity of the Accounting {@link Scheme} used in this period.
     * @return the identity of the Accounting {@link Scheme} used in this period.
     */
    String getSchemeId();


    /**
     * Tells whether the accounting period has already ended or not.
     * @return true if the accounting period is over, false otherwise.
     */
    boolean hasEnded();

    /**
     * Ends the accounting period.
     */
    void end();
    
}
