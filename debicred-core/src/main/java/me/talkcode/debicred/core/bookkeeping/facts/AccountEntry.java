package me.talkcode.debicred.core.bookkeeping.facts;

import me.talkcode.debicred.core.bookkeeping.books.Ledger;
import me.talkcode.debicred.core.bookkeeping.model.Account;
import me.talkcode.debicred.core.bookkeeping.model.Amount;

import java.time.LocalDate;

/**
 * Represents a movement in a {@link  Ledger} {@link  Account}.
 */
public interface AccountEntry {

    LocalDate getEntryDate();

    Amount getPostEntryBalance();

    Amount getEntryAmount();

}
