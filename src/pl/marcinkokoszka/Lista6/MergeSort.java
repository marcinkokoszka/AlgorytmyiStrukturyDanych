package pl.marcinkokoszka.Lista6;

import pl.marcinkokoszka.Lista1.iterators.Iterator;
import pl.marcinkokoszka.Lista4.ArrayList;
import pl.marcinkokoszka.Lista4.List;
import pl.marcinkokoszka.Lista5.Comparators.Comparator;
import pl.marcinkokoszka.Lista5.ListSorter;

/**
 * Created by kokoseq on 30.04.2017.
 */
public class MergeSort implements ListSorter {

    private int assignments = 0;
    private int compares = 0;

    private final Comparator _comparator;

    public MergeSort(Comparator comparator)  {
        _comparator = comparator;
    }

    public List sort(List list) {
        return mergesort(list, 0, list.size() - 1);
    }

    private List mergesort(List list, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            List result = new ArrayList();
            result.add(list.get(startIndex));
            return result;
        }
        int splitIndex = startIndex + (endIndex - startIndex) / 2;
        return merge(mergesort(list, startIndex, splitIndex), mergesort(list, splitIndex + 1, endIndex));
    }


    private List merge (List left, List right){
        List result = new ArrayList();
        Iterator l = left.iterator();
        Iterator r = right.iterator();
        l.first();
        r.first();
        while (!l.isDone() && !r.isDone()) {
            compares++;
            if (_comparator.compare(l.current(), r.current()) <= 0) {
                result.add(l.current());
                assignments++;
                l.next();
            } else {
                result.add(r.current());
                assignments++;
                r.next();
            }
        }
        while (!l.isDone()) {
            result.add(l.current());
            assignments++;
            l.next();
        }
        while (!r.isDone()) {
            result.add(r.current());
            assignments++;
            r.next();
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
} // koniec MergeSortListSorter
