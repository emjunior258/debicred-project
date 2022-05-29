package me.talkcode.commons.query;

import java.util.Optional;


/**
 * Represents results of a peformed query.
 */
public interface QueryResults<T> {

    long count();
    Iterable<T> items();

    boolean continues();
    Optional<QuerySpecification<T>> continuationQuerySpec();

}
