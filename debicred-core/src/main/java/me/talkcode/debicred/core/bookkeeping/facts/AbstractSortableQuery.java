package me.talkcode.debicred.core.bookkeeping.facts;


import me.talkcode.debicred.core.commons.Sorting;

/**
 * A query of a collection that is sortable
 */
public abstract class AbstractSortableQuery<T> extends AbstractQuery<T> {

    private Sorting sorting = Sorting.Ascending;

    protected void setSorting(Sorting sorting){
        this.sorting = sorting;
    }

    public Sorting getSorting() {
        return sorting;
    }
}
