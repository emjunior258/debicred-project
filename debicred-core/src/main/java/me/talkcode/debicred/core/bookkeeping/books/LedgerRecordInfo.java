package me.talkcode.debicred.core.bookkeeping.books;

import me.talkcode.debicred.core.bookkeeping.model.Account;
import me.talkcode.debicred.core.bookkeeping.model.AccountClass;

/**
 * Basic information about a {@link LedgerRecord}.
 */
public class LedgerRecordInfo {

    /**
     * Represents the type of {@link LedgerRecord}.
     */
    public enum RecordType {

        /**
         * An {@link Account} with child {@link Account}s.
         */
        ParentAccount(Account.class),

        /**
         * An {@link Account} that doesn't have child {@link Account}s.
         */
        LeafAccount(Account.class),

        /**
         * A record that holds {@link Account}s of the same category
         */
        Class(AccountClass.class);

        private Class javaClass;

        private RecordType(Class javaClass) {
            this.javaClass = javaClass;
        }

    }

    private RecordType type;
    private String id;
    private String name;

    public LedgerRecordInfo(RecordType type, String id, String name) {
        if(type == null)
            throw new IllegalArgumentException("type must not be null");
        if(id == null || id.isEmpty())
            throw new IllegalArgumentException("id must not be null nor empty");
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("name must not be null nor empty");
        this.type = type;
        this.id = id;
        this.name = name;
    }


    public RecordType getType() {
        return this.type;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }


}
