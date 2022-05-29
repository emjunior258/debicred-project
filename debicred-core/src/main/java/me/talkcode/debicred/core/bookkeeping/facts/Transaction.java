package me.talkcode.debicred.core.bookkeeping.facts;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import me.talkcode.debicred.core.AccountingViolationException;
import me.talkcode.debicred.core.bookkeeping.books.Ledger;
import me.talkcode.debicred.core.bookkeeping.model.Amount;
import me.talkcode.debicred.core.commons.ToString;

/**
 * Represents a financial transaction
 */
public class Transaction {

    private String summary;
    private Set<LedgerEntry> entries;

    private LocalDate date;

    private Amount amount;

    private TransactionRef ref;

    private Transaction(String summary, Collection<LedgerEntry> entries, LocalDate date, TransactionRef ref) {
        this.summary = summary;
        this.entries = Set.copyOf(entries);
        this.date = date;
        this.ref = ref;
        this.amount = new Amount(entries.stream()
                .filter(entry -> entry.getType() == Ledger.EntryType.Credit)
                .map(LedgerEntry::getAmount).mapToDouble(Amount::value).sum());
    }


    public static Transaction create(String summary, Collection<LedgerEntry> entries, LocalDate date) {
        if(summary==null || summary.isEmpty())
            throw new IllegalArgumentException("transaction summary must not be null nor empty");
        if(entries==null || entries.isEmpty())
            throw new IllegalArgumentException("ledger entries collection must not be null nor empty");
        if(date==null)
            throw new IllegalArgumentException("transaction date must not be null");
        var creditsAmount = (Double) entries.stream()
                .filter(entry -> entry.getType() == Ledger.EntryType.Credit)
                .map(credit -> credit.getAmount().value()).mapToDouble(Double::doubleValue).sum();
        var debitsAmount = (Double) entries.stream()
                .filter(entry -> entry.getType() == Ledger.EntryType.Debit)
                .map(credit -> credit.getAmount().value()).mapToDouble(Double::doubleValue).sum();
        if(!creditsAmount.equals(debitsAmount))
            throw new UnbalancedTransactionException();
        var addressEntriesMap = entries.stream().collect(Collectors
                .groupingBy(LedgerEntry::getAccountAddress));
        var multiEntryAddresses = addressEntriesMap.values().stream().filter(entryList -> entryList.size() > 1)
                .map(entryList -> entryList.get(0).getAccountAddress()).toList();
        if(!multiEntryAddresses.isEmpty())
            throw new AccountingViolationException("There are multiple posting entries with the same account addresses: " + ToString.of(multiEntryAddresses));
        return new Transaction(summary, entries, date, null);
    }

    public String getSummary() {
        return this.summary;
    }

    public Set<LedgerEntry> getEntries() {
        return  this.entries;
    }

    public Amount getAmount(){
        return this.amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Optional<TransactionRef> getRef(){
        return Optional.ofNullable(ref);
    }

    public boolean hasBeenPosted() {
        return ref != null;
    }

    /**
     * Creates a new transaction with the exact same details with a {@link TransactionRef} set.
     * @param ref the {@link TransactionRef} to be set on the new copy.
     * @return a new transaction with the exact same details with the {@link TransactionRef} set
     */
    public Transaction copyWithRef(TransactionRef ref){
        if(ref==null)
            throw new IllegalArgumentException("ref must not be null");
        return new Transaction(summary, entries, date, ref);
    }

    public String toString() {
        return String.format("%s[ref=%s, summary=%s, amount=%s, date=%s, entries=%s]", Transaction.class.getSimpleName(), ref, summary, amount, date, ToString.of(entries));
    }
    
}
