# Debicred-core
The core of the debicred system.


## Features

* Ability to support any accounting plan
* Ability to (virtually) store accounting information using any persistence mechanism
* Ability to watch for new financial transaction
* Ability to prevent financial transactions from proceeding


## Domain model

All accounting operations happen within an `AccountingContext`, which essentially sets the `Organization` and the `AccountingPeriod` for all the transactions. The `AccountingContext` may also have a set of attached `TransactionListener`s and `TransactionFilter`s.

All accounting transactions are written to both a `Ledger` and a `Journal` which are specific to the `AccountingPeriod`.

The `AccountingPeriod` can be initialized by an accounting `Scheme`, in order to ensure that the `Ledger` of the accounting period has a standard structure.

The `Ledger` is organized in `AccountClass`es which contain `Account`s. An `Account` can have child `Account`s.

The `Ledger` can be initialized by an Accounting `Scheme`.

The accounting `Scheme` decides which `AccountClass`es and  `Account`s are created in the `Ledger`.

Accounting `Scheme`s can be added and removed over time.
