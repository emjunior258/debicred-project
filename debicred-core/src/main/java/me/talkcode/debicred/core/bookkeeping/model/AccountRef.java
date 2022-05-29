package me.talkcode.debicred.core.bookkeeping.model;

/**
 * A unique reference of a Ledger {@link Account}.
 */
public class AccountRef {

    private String value;

    public static AccountRef of(String value) {
        return new AccountRef(value);
    }

    public AccountRef (String value) {
        this.value = value;
    }

    public String getValue(){
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
