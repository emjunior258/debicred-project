package me.talkcode.debicred.core.bookkeeping.facts;


/**
 * Represents a unique reference of an accounting transaction
 */
public class TransactionRef {
    
    private String value;

    TransactionRef(String value) {
        if(value==null || value.isEmpty())
            throw new IllegalArgumentException("value must not be null nor empty");
        this.value = value;
    }

    public static TransactionRef of(String value){
        return new TransactionRef(value);
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public int hashCode(){
        return value.hashCode();
    }

    @Override
    public String toString(){
        return this.value;
    }

}
