package me.talkcode.debicred.core.bookkeeping.books;

import java.util.Optional;

import me.talkcode.debicred.core.bookkeeping.Book;
import me.talkcode.debicred.core.bookkeeping.facts.Transaction;
import me.talkcode.debicred.core.bookkeeping.facts.TransactionRef;
import me.talkcode.commons.query.Queryable;
import me.talkcode.debicred.core.bookkeeping.model.Account;

/**
 * The book in which all financial transactions of a business are recorded
 */
public interface Journal extends Book {
    
    /**
     * Posts a financial transaction, causing the respective debits and credits to be posted into the specified ledger {@link Account}s.
     * @param transaction the transaction to be posted
     * @return a {@link Transaction} object with a {@link TransactionRef} set.
     */
    Transaction post(Transaction transaction);

    Optional<Transaction> getByReference(TransactionRef ref);

    Queryable<Transaction> transactions();

}
