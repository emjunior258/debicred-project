package me.talkcode.debicred.core.bookkeeping.model;

import java.util.Locale;

/**
 * Represents a financial amount
 */
public record Amount(double value) {

    @Override
    public String toString(){
        return String.valueOf(value);
    }

    public double toCurrency(Locale locale) {
        //TODO: Implement
        throw new UnsupportedOperationException();
    }
    
}
