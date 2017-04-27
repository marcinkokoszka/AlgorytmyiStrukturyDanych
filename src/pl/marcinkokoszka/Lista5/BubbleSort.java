package pl.marcinkokoszka.Lista5;

import pl.marcinkokoszka.Lista4.List;
import pl.marcinkokoszka.Lista5.Comparators.Comparator;

/**
 * Created by kokoseq on 25.04.2017.
 */

public class BubbleSort implements ListSorter, ListSorterCounter {

    private int assignments = 0;
    private int compares = 0;

    private final Comparator _comparator;

    public BubbleSort(Comparator comparator) { _comparator = comparator; }

    @Override
    public List sort(List list) {
        int size = list.size();

        for (int pass = 1; pass < size; ++pass) {
            for (int left = 0; left < (size - pass); ++left) {
                int right = left + 1;

                this.compares++;
                if (_comparator.compare(list.get(left), list.get(right)) > 0) {
                    swap(list, left, right);
                }
            }

        }
        return list;
    }

    private void swap(List list, int left, int right) {
        Object temp = list.get(left);
        assignments++;
        list.set(left, list.get(right));
        assignments++;
        list.set(right, temp);
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