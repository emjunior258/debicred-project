package me.talkcode.debicred.core.bookkeeping.books;

/**
 * A Record in Ledger.
 * 
 * Ledger Records are stored hierarchically, where one record can be child of another.
 * 
 * A ledger record has an identity and a name. The identity must be unique in the hierarchical level where the Record is placed.
 * 
 * The Identity of a Ledger record is a sequence of digits, Examples: 00001, 1010, 1111, 1300010.
 * 
 * The address of a record is the concatenation of the identities of all the parent records (in order) plus it's own identity.
 * 
 * Let's say there is a record with identity "1010", which is in the following hierarchy of records:  1 → 21 → 12 → 1010. The Address of the Record will be 121121010
 * 
 */
public interface LedgerRecord {

    /**
     * Gets the unique identifier of the record
     * @return the unique identifier of the record
     */
    String getId();

    /**
     * Gets the name of the record
     * @return the name of the record
     */
    String getName();

    /**
     * The address that can be used to locate the record in the {@link Ledger}.
     * @return address that can be used to locate the record the {@link Ledger}
     */
    LedgerAddress getAddress();

}
