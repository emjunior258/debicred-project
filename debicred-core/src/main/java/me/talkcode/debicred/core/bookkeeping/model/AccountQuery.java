package me.talkcode.debicred.core.bookkeeping.model;

import me.talkcode.debicred.core.bookkeeping.books.LedgerAddress;
import me.talkcode.commons.query.QuerySpecification;

public class AccountQuery implements QuerySpecification<Account>  {

    private AccountNature nature;
    private long limit = 10;
    private LedgerAddress parentPath;

    private AccountQuery(){

    }

    public final static Builder builder(){
        return new Builder();
    }

    private static class Builder {

        private AccountQuery query;

        Builder(){
            this.query = new AccountQuery();
        }

        public Builder limit(long limit){
            if(limit<1)
                throw new IllegalArgumentException("limit must be higher than zero");
            this.query.limit = limit;
            return this;
        }

        public Builder nature(AccountNature nature){
            if(nature==null)
                throw new IllegalArgumentException("nature must not be null");
            this.query.nature = nature;
            return this;
        }

        public Builder parent(LedgerAddress path){
            if(path==null)
                throw new IllegalArgumentException("path must not be null");
            this.query.parentPath = path;
            return this;
        }

        public AccountQuery build() {
            return this.query;
        }

    }

}
