package me.talkcode.debicred.core.commons;

import java.util.ArrayList;
import java.util.List;

public class CollectionMatcher<T> {

    public enum Condition {
        AnyOf, AllOf
    }

    private Condition condition;
    private List<T> values = new ArrayList<>();

    private CollectionMatcher(Condition condition, List<T> values){
        this.condition = condition;
        this.values.addAll(values);
    }

    public Condition getCondition(){
        return this.condition;
    }

    public List<T> getValues(){
        return this.values;
    }

    public static <T> CollectionMatcher<T> anyOf(List<T> values){
        if(values==null||values.isEmpty())
            throw new IllegalArgumentException("values must not be null nor empty");
        return new CollectionMatcher<>(Condition.AnyOf,  
            values);
    }

    public static <T> CollectionMatcher<T> allOf(List<T> values){
        if(values==null||values.isEmpty())
            throw new IllegalArgumentException("values must not be null nor empty");
        return new CollectionMatcher<>(Condition.AllOf,
            values);
    }

    public static <T> CollectionMatcher<T> build(Condition condition, List<T> values) {
        if(condition==null)
            throw new IllegalArgumentException("condition must not be null");
        if(values==null||values.isEmpty())
            throw new IllegalArgumentException("values must not be null nor empty");
        return new CollectionMatcher<>(condition, values);
    }

}
