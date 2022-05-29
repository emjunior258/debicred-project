package me.talkcode.debicred.core.commons;

public class StringMatcher {

    public enum Condition {
        Equals,
        EndsWith,
        StartsWith,
        Contains
    }
    
    private Condition condition;
    private String value;

    private StringMatcher(Condition condition, String value){
        if(condition==null)
            throw new IllegalArgumentException("condition must not be null");
        if(value==null || value.isEmpty())
            throw new IllegalArgumentException("value must not be null nor empty");
        this.condition = condition;
        this.value = value;
    }

    public Condition getCondition(){
        return this.condition;
    }

    public String getValue(){
        return this.value;
    }

    public static StringMatcher endsWith(String value){
        if(value==null || value.isEmpty())
            throw new IllegalArgumentException("value must not be null nor empty");
        return new StringMatcher(Condition.EndsWith, value);
    }

    public static StringMatcher startWith(String value){
        if(value==null || value.isEmpty())
            throw new IllegalArgumentException("value must not be null nor empty");
        return new StringMatcher(Condition.StartsWith, value);
    }

    public static StringMatcher contains(String value){
        if(value==null || value.isEmpty())
            throw new IllegalArgumentException("value must not be null nor empty");
        return new StringMatcher(Condition.Contains, value);
    }

    public static StringMatcher equals(String value){
        if(value==null || value.isEmpty())
            throw new IllegalArgumentException("value must not be null nor empty");
        return new StringMatcher(Condition.Equals, value);
    }

}
