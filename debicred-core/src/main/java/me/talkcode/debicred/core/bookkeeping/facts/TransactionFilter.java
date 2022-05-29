package me.talkcode.debicred.core.bookkeeping.facts;

/**
 * Intercepts {@link Transaction}s before they are committed and has the ability to stop them from happening or even replacing them.
 */
@FunctionalInterface
public interface TransactionFilter {
 
    void filter(TransactionFilterChain filtering);
    
}
