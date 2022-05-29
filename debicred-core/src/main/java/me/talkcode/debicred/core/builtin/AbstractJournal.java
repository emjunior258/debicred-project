package me.talkcode.debicred.core.builtin;

import me.talkcode.debicred.core.bookkeeping.books.Journal;
import me.talkcode.debicred.core.bookkeeping.facts.LedgerEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.talkcode.debicred.core.Accounting;
import me.talkcode.debicred.core.bookkeeping.facts.Transaction;
import me.talkcode.debicred.core.bookkeeping.facts.TransactionRef;
import me.talkcode.debicred.core.bookkeeping.facts.TransactionFilter;
import me.talkcode.debicred.core.bookkeeping.facts.TransactionListener;

/**
 * An abstract implementation of a {@link Journal}.
 * Implementations of {@link Journal} are expected to extend this class, as it performs some heavy lifting.
 * This class implements the {@link Transaction} posting logic, including {@link TransactionFilter}ing and execution of {@link TransactionListener}.
 *
 * This implementation works with {@link AbstractContext}
 */
public abstract class AbstractJournal implements Journal {

    private static final Logger LOGGER = LogManager.getLogger(AbstractJournal.class);

    //TODO: Tracing + Logging
    public Transaction post(Transaction transaction) {
        if(transaction==null)
            throw new IllegalArgumentException("transaction must not be null");
        LOGGER.info("Posting a transaction of amount " + transaction.getAmount());
        LOGGER.trace(transaction);
        LOGGER.debug("Executing transaction filters");
        //TODO: Filter transaction
        var ledger = Accounting.currentContext().currentPeriod().getLedger();
        for(LedgerEntry entry: transaction.getEntries()) {
            LOGGER.debug(String.format("Posting entry [type=%s, accountAddress=%s, amount=%s]", entry.getType(),
                    entry.getAccountAddress(),
                    entry.getAmount()));
            entry.post(ledger, transaction.getDate());
            LOGGER.debug("Entry posted successfully");
        }
        var transactionRef = this.persistTransaction(transaction);
        var postedTransaction = transaction.copyWithRef(transactionRef);
        LOGGER.debug("Triggering notifications");
        this.transactionNotify(postedTransaction);
        LOGGER.info("Transaction posted successfully");
        return postedTransaction;
    }

    public abstract TransactionRef persistTransaction(Transaction transaction);

    public void transactionNotify(Transaction transaction) {
        //TODO: Trigger transaction listeners (asynchronous)
    }
    
}
