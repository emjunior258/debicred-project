package me.talkcode.debicred.core.commons;

import java.util.Optional;

public class Range<T> {

    private T from;
    private T to;

    private Range(T from, T to){
        this.from = from;
        this.to = to;
    }

    public Optional<T> getLowerBound(){
        return Optional.ofNullable(from);
    }

    public Optional<T> getUpperBound(){
        return Optional.ofNullable(to);
    }

    public static <T> Range<T> until(T upperBound){
        if(upperBound==null)
            throw new IllegalArgumentException("upper bound must not be null");
        return new Range<T>(null, upperBound);
    }

    public static <T> Range<T> from(T lowerBound){
        if(lowerBound==null)
            throw new IllegalArgumentException("lower bound must not be null");
        return new Range<T>(lowerBound, null);
    }

    public static <T> Range<T> between(T lowerBound, T upperBound){
        if(lowerBound==null || upperBound==null)
            throw new IllegalArgumentException("neither lower bound nor upper bound must be null");
        return new Range<T>(lowerBound, upperBound);
    }
    
}
