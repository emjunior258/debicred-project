package me.talkcode.debicred.core.bookkeeping.facts;

import java.time.LocalDate;
import java.util.Optional;

import me.talkcode.debicred.core.bookkeeping.books.LedgerAddress;
import me.talkcode.debicred.core.bookkeeping.model.Amount;
import me.talkcode.debicred.core.commons.CollectionMatcher;
import me.talkcode.debicred.core.commons.Range;
import me.talkcode.debicred.core.commons.Sorting;
import me.talkcode.debicred.core.commons.StringMatcher;
import me.talkcode.debicred.core.bookkeeping.model.Account;

/**
 * A specification to query {@link Transaction}s.
 * 
 * This query specification object allows you to specify the following parameters:
 * <ul>
 *    <li><b>limit</b> - The maximum number of query result items to be returned. Default value is 25</li>
 *    <li><b>sorting</b> - The order in which the query results must be sorted. The sorting is based on the {@link Transaction} posting datetime. Default value is <b>Ascending</b>.
 *    <li><b>dateRange</b> - Use this when you want to filter only {@link Transaction}s that happened within a particular calendar interval. The range is inclusive.
 *    <li><b>amountRange</b> - Use this when you want to filter {@link Transaction}s based on their amount. The range of the amount is inclusive.
 *    <li><b>descriptionMatcher</b> - Use this to filter {@link Transaction}s based on their description
 *    <li><b>accountsMatcher</b> - Use this to filter {@link Transaction}s based on the {@link Account}s that have been affected.
* </ul>
 * 
 */
public class TransactionQuery extends AbstractSortableQuery<Transaction>  {

    private Range<LocalDate> dateRange;
    private Range<Amount> amountRange;
    private StringMatcher descriptionMatcher;

    private CollectionMatcher<LedgerAddress> accountsMatcher;

    private TransactionQuery(){

    }

    public Optional<Range<LocalDate>> getDateRange(){
        return Optional.ofNullable(this.dateRange);
    }

    public Optional<Range<Amount>> getAmountRange(){
        return Optional.ofNullable(this.amountRange);
    }

    public Optional<StringMatcher> getDescriptionMatch(){
        return Optional.ofNullable(this.descriptionMatcher);
    }

    public Optional<CollectionMatcher<LedgerAddress>> getAccountsMatcher(){
        return Optional.ofNullable(this.accountsMatcher);
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
    
        private TransactionQuery query = new TransactionQuery();

        private Builder(){

        }

        public Builder limit(long limit){
            if(limit < 1)
                throw new IllegalArgumentException("limit must be higher than 0");
            this.query.setLimit(limit);
            return this;
        }

        public Builder dateRange(Range<LocalDate> dateRange){
            if(dateRange==null)
                throw new IllegalArgumentException("dateRange must not be null");
            this.query.dateRange = dateRange;
            return this;
        }

        public Builder amountRange(Range<Amount> amountRange){
            if(amountRange==null)
                throw new IllegalArgumentException("amountRange must not be null");
            this.query.amountRange = amountRange;
            return this;
        }

        public Builder description(StringMatcher descriptionMatch){
            if(descriptionMatch==null)
                throw new IllegalArgumentException("descriptionMatch must not be null");
            this.query.descriptionMatcher = descriptionMatch;
            return this;
        }

        public Builder sorting(Sorting sorting){
            if(sorting==null)
                throw new IllegalArgumentException("sorting must not be null");
            this.query.setSorting(sorting);
            return this;
        }

        public Builder accounts(CollectionMatcher<LedgerAddress> accountsMatcher){
            if(accountsMatcher==null)
                throw new IllegalArgumentException("accountsMatcher must not be null");
            this.query.accountsMatcher = accountsMatcher;
            return this;
            
        }

        public TransactionQuery build(){
            return this.query;
        }

    }

}
