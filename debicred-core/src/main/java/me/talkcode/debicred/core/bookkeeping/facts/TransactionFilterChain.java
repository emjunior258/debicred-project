package me.talkcode.debicred.core.bookkeeping.facts;


/**
 * Represents a chain of {@link  TransactionFilter}s.
 */
public interface TransactionFilterChain {

    /**
     * Advances to the next {@link TransactionFilter} in the chain.
     */
    void proceed();

    /**
     * Replaces the {@link Transaction} that is being filtered. It will not restart the chain. The new {@link Transaction} object will be passed to the next {@link TransactionFilter} in the chain.
     * @param transaction the {@link Transaction} to replace the one being filtered.
     */
    void replaceWith(Transaction transaction);


    /**
     * Gets the {@link Transaction} that is currently being filtered.
     * @return the {@link Transaction} that is currently being filtered.
     */
    Transaction getTransaction();
}
