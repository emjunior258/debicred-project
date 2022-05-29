package me.talkcode.debicred.core;

import java.time.LocalDate;
import java.util.Set;

import me.talkcode.debicred.core.bookkeeping.books.Scheme;
import me.talkcode.debicred.core.bookkeeping.model.AccountingPeriod;
import me.talkcode.debicred.core.bookkeeping.facts.TransactionFilter;
import me.talkcode.debicred.core.bookkeeping.facts.TransactionListener;
import me.talkcode.debicred.core.bookkeeping.facts.Transaction;

/**
 * The context in which all accounting operations take place. All accounting records are about an {@link Organization}.
 * There can be multiple contexts in the system, but there can only be one active context in a {@link Thread} at a time.
 *
 * There can only be one active {@link AccountingPeriod} in the context.
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
     * Gets the {@link AccountingPeriod}s available. The available {@link AccountingPeriod}s is a subset of all {@link AccountingPeriod}s created in the context.
     * @return the {@link AccountingPeriod}s available.
     */
    Set<AccountingPeriod> listPeriods();


    /**
     * Starts a new {@link AccountingPeriod} using the default accounting {@link Scheme}.
     * @param start the {@link AccountingPeriod} start date. Can be any date as long as it is before the end date.
     * @param end the {@link AccountingPeriod} start date. Can be any date as long as it is after the start date.
     * @return the initiated  {@link AccountingPeriod}
     * @throws AccountingViolationException when the end date is before the start date
     * @throws AccountingException when there is no default accounting {@link Scheme} set
     * @throws ConcurrentPeriodException when attempting to start a new {@link AccountingPeriod} when there is another active.
     */
    AccountingPeriod newPeriod(LocalDate start, LocalDate end);

    /**
     * Starts a new {@link AccountingPeriod} using a specific accounting {@link Scheme}.
     * There will no exception raised in case the {@link TransactionFilter} is already part of the context.
     * @param start the {@link AccountingPeriod} start date. Can be any date as long as it is before the end date.
     * @param end the {@link AccountingPeriod} start date. Can be any date as long as it is after the start date.
     * @param scheme the accounting {@link Scheme} to be used for the period.
     * @return the initiated  {@link AccountingPeriod}
     * @throws AccountingViolationException when the end date is before the start date
     * @throws ConcurrentPeriodException when attempting to start a new {@link AccountingPeriod} when there is another active.
     */
    AccountingPeriod newPeriod(LocalDate start, LocalDate end, Scheme scheme) throws ConcurrentPeriodException;


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
