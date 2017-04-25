package pl.marcinkokoszka.Lista5;

import pl.marcinkokoszka.Lista2.LinkedList;
import pl.marcinkokoszka.Lista1.iterators.Iterator;
import pl.marcinkokoszka.Lista2.List;

import java.util.Comparator;

/**
 * Created by kokoseq on 25.04.2017.
 */

public class InsertSort<T extends Comparable> implements ListSorter<T>, ListSorterCounter {

    private int assignments = 0;
    private int compares = 0;

    private final Comparator _comparator;

    public InsertSort(Comparator comparator) { _comparator = comparator; }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> sort(List<T> list) {
        final List<T> result = new LinkedList<>();
        Iterator it = list.iterator();
        for (it.first(); !it.isDone(); it.next()) {
            int slot = result.size();
            while (slot>0) {
                compares++;
                if (_comparator.compare(it.current(), result.get(slot-1)) >= 0) { break; }
                --slot;
            }
            assignments++;
            result.insert(slot, (T) it.current());
        }
        return result;
    }

    @Override
    public int getAssignments() {
        return assignments;
    }

    @Override
    public int getCompares() {
        return compares;
    }

    @Override
    public void setAssignments(int assignments) {
        this.assignments = assignments;
    }

    @Override
    public void setCompares(int compares) {
        this.compares = compares;
    }
}