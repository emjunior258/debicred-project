package me.talkcode.debicred.core;

import me.talkcode.debicred.core.bookkeeping.model.AccountingPeriod;
import me.talkcode.debicred.core.bookkeeping.facts.TransactionFilter;
import me.talkcode.debicred.core.bookkeeping.facts.TransactionListener;
import me.talkcode.debicred.core.bookkeeping.facts.Transaction;

/**
 * The context in which all accounting operations take place. All accounting records are about an {@link Organization}.
 * There can be multiple contexts in the system, but there can only be one active context in a {@link Thread} at a time.
 *
 */
public interface AccountingContext {


    /**
     * Gets the {@link  Organization} of which the accounting is all about.
     * @return the {@link  Organization} of which the accounting is all about
     */
    Organization getOrganization();


    /**
     * Gets the current {@link AccountingPeriod}
     * @return the active {@link AccountingPeriod}.
     * @throws NoActivePeriodException whenever there is no active {@link  AccountingPeriod}.
     */
    AccountingPeriod currentPeriod() throws NoActivePeriodException;

    /**
     * Adds a {@link TransactionFilter} to the context. The filter will be added to the filtering chain of {@link Transaction}s posted after this method call.
     * @param filter the {@link TransactionFilter} to be added.
     * @param priority the priority to set on the {@link TransactionFilter}. The {@link TransactionFilter}s with higher priority are executed first.
     */
    void addFilter(TransactionFilter filter, int priority);

    /**
     * Removes a {@link TransactionFilter} from the context. The filter will not be present in the filtering chain of {@link Transaction}s posted after this method call.
     * There will no exception raised in case the {@link TransactionFilter} wasn't previously added to the context
     * @param filter the {@link TransactionFilter} to be removed
     */
    void removeFilter(TransactionFilter filter);


    /**
     * Adds a {@link TransactionListener} to the context. The Listener will receive notifications for all {@link Transaction}s initiated after this method call.
     * There will be no exception raised in case the {@link TransactionListener} was already added to the context.
     * @param listener the {@link TransactionListener} to be added to the context.
     */
    void addListener(TransactionListener listener);

    /**
     * Removes a {@link TransactionListener} from the context. The Listener will no longer receive any notifications raised after this method call.
     * There will be no exception raise in case the {@link TransactionListener} was not previously added to the context.
     * @param listener the {@link TransactionListener} to be removed.
     */
    void removeListener(TransactionListener listener);

}
