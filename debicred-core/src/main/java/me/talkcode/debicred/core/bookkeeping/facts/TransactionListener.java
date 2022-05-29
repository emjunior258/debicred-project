package me.talkcode.debicred.core.bookkeeping.facts;

/**
 * Receives notifications about posted {@link Transaction}s.
 */
@FunctionalInterface
public interface TransactionListener {

    /**
     * Receives a notification of a successfully posted {@link Transaction}.
     * @param transaction the successfully posted transaction.
     */
    void posted(Transaction transaction);
    
}
