package me.talkcode.debicred.core.bookkeeping.books;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.regex.Pattern;

/**
 * A pointer to a {@link LedgerRecord}.
 * A format of a Ledger address is defined by the following Regular expression: ^(\d+)*$
 */
public record LedgerAddress(String value){

    private static final Logger LOGGER = LogManager.getLogger(LedgerAddress.class);
    public static final Pattern PATTERN = Pattern.compile("^(\\d+)*$");

    public LedgerAddress {
        if(value==null || value.isEmpty()){
            if(!PATTERN.matcher(value).matches())
                throw new IllegalArgumentException("not a valid ledger address");
        }
    }

    public Optional<LedgerRecordInfo> getRecordInfo(Ledger ledger) {
        if(ledger == null)
            throw new IllegalArgumentException("ledger must not be null");
        LOGGER.debug("Getting info about record under " + value);
        return ledger.getRecordInfo(this);
    }

    public String toString() {
        return value;
    }

}
