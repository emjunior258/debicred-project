package me.talkcode.debicred.core.bookkeeping.facts;

import me.talkcode.commons.query.QuerySpecification;

public abstract class AbstractQuery<T> implements QuerySpecification<T> {

    private long limit = 25;

    protected void setLimit(long limit){
        this.limit = limit;
    }

    public long getLimit() {
        return limit;
    }
}
