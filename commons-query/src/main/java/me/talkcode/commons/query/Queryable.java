package me.talkcode.commons.query;


/**
 * A collection that can be queried.
 */
public interface Queryable <T> {
    
    QueryResults<T> query(QuerySpecification<T> specification);

}
