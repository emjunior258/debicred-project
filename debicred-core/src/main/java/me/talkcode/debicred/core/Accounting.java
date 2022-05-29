package me.talkcode.debicred.core;

import me.talkcode.debicred.core.bookkeeping.books.Scheme;
import me.talkcode.debicred.core.bookkeeping.model.AccountingPeriod;

import java.util.Optional;
import java.util.Set;

/**
 * The entry point of the Accounting-core.
 */
public final class Accounting {

    private static ThreadLocal<AccountingContext> ACTIVE_CONTEXT = new ThreadLocal<>();

    /**
     * Sets the active {@link AccountingContext} for the calling {@link Thread}.
     * @param context the {@link AccountingContext} to be set.
     */
    public static void setContext(AccountingContext context){
        if(context==null)
            throw new IllegalArgumentException("context must not be null");
        ACTIVE_CONTEXT.set(context);
    }

    /**
     * Gets the active {@link AccountingContext} for the calling {@link Thread}.
     * @return the {@link AccountingContext} that is active.
     * @throws NoActiveContextException when there is no active {@link  AccountingContext}.
     */
    public static AccountingContext currentContext() {
        AccountingContext context = ACTIVE_CONTEXT.get();
        if(context==null)
            throw new NoActiveContextException();
        return context;
    }

    /**
     * Clears the active {@link AccountingContext} for the calling {@link Thread}
     */
    public static void unsetCurrentContext() {
        ACTIVE_CONTEXT.remove();
    }

    public static Optional<Scheme> getScheme(String id) {

        //TODO: Implement
        throw new UnsupportedOperationException();

    }

    public static Set<Scheme> getSchemes() {

        //TODO: Implement
        throw new UnsupportedOperationException();

    }

    /**
     * Sets the accounting {@link Scheme} to be used when creating a new {@link AccountingPeriod} without specifying a {@link Scheme}.
     * @param scheme {@link Scheme} to be used when creating a new {@link AccountingPeriod} without specifying a {@link Scheme}
     */
    public static void setDefaultScheme(Scheme scheme) {

        //TODO: Implement
        throw new UnsupportedOperationException();

    }

    /**
     * Gets the accounting {@link Scheme} to be used when creating a new {@link AccountingPeriod} without specifying a {@link Scheme}.
     * @return an empty {@link Optional<Scheme>} in case there is no default {@link Scheme} set, otherwise it returns an {@link Optional} with the set {@link Scheme}.
     */
    public static Optional<Scheme>  getDefaultScheme() {

        //TODO: Implement
        throw new UnsupportedOperationException();

    }


}
