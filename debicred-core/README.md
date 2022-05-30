# Debicred-core
The core of the debicred system.


## Features

* Ability to support any accounting plan
* Ability to (virtually) store accounting information using any persistence mechanism
* Ability to watch for new financial transaction
* Ability to prevent financial transactions from proceeding


## Domain model

All accounting operations happen within an `AccountingContext`, which essentially defines the `Organization` and the `AccountingPeriod`, plus a set of `TransactionListener`s and `TransactionFilter`s.

The `AccountingPeriod` can be initialized by an accounting `Scheme`, in order to ensure that the `Ledger` of the accounting period has a standard structure.

Accounting `Scheme`s can be plugged into the system.
