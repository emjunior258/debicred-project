package me.talkcode.debicred.core.bookkeeping.facts;


import me.talkcode.debicred.core.bookkeeping.books.Ledger;
import me.talkcode.debicred.core.bookkeeping.model.Amount;
import me.talkcode.debicred.core.commons.Range;

import java.time.LocalDate;

public class AccountEntryQuery extends AbstractSortableQuery<AccountEntry> {

    private Ledger.EntryType entryType;
    private Range<LocalDate> dateRange;
    private Range<Amount> amountRange;

    private AccountEntryQuery(){

    }

    public Ledger.EntryType getEntryType() {
        return entryType;
    }

    public Range<Amount> getAmountRange() {
        return amountRange;
    }

    public Range<LocalDate> getDateRange() {
        return dateRange;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {

        private AccountEntryQuery query = new AccountEntryQuery();

        private Builder(){

        }

        public Builder entryType(Ledger.EntryType type) {
            if(type == null)
                throw new IllegalArgumentException("type must not be null");
            this.query.entryType = type;
            return this;
        }

        public Builder dateRange(Range<LocalDate> dateRange) {
            if(dateRange == null)
                throw new IllegalArgumentException("dateRange must not be null");
            this.query.dateRange = dateRange;
            return this;
        }

        public Builder amountRange(Range<Amount> amountRange) {
            if(amountRange == null)
                throw new IllegalArgumentException("amountRange must not be null");
            this.query.amountRange = amountRange;
            return this;
        }

        public AccountEntryQuery build() {
            return this.query;
        }

    }


}
