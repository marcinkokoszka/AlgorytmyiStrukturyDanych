package pl.marcinkokoszka.Lista6;

import pl.marcinkokoszka.Lista4.List;
import pl.marcinkokoszka.Lista5.Comparators.Comparator;
import pl.marcinkokoszka.Lista5.ListSorter;

/**
 * Created by kokoseq on 30.04.2017.
 */
public class QuickSort implements ListSorter {

    private int assignments = 0;
    private int compares = 0;

    private final Comparator _comparator;

    public QuickSort (Comparator comparator) {
        _comparator = comparator;
    }
    public List sort(List list) {
        quicksort(list, 0, list.size() - 1);
        return list;
    }

    private void quicksort(List list, int startIndex, int endIndex) {
        if (endIndex > startIndex) {
            Object value=list.get(endIndex);
            int partition = partition(list, value, startIndex, endIndex - 1);
            compares++;
            if (_comparator.compare(list.get(partition), value) < 0) ++partition;
            swap(list, partition, endIndex);
            quicksort(list, startIndex, partition - 1);
            quicksort(list, partition + 1, endIndex);
        }
    }

    private int partition(List list, Object value, int leftIndex, int rightIndex) {
        int left = leftIndex;
        int right = rightIndex;
        while (left < right) {
            compares++;
            if (_comparator.compare(list.get(left), value) < 0) {
                ++left;
                continue;
            }
            compares++;
            if (_comparator.compare(list.get(right), value) >= 0) {
                --right;
                continue;
            }
            swap(list, left, right);
            ++left;
        }
        return left; // zwraca znalezioną pozycję elementu dzielącego
    }

    private void swap(List list, int left, int right) {
        if (left != right) {
            Object temp = list.get(left);
            list.set(left, list.get(right));
            assignments++;
            list.set(right, temp);
            assignments++;
        }
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
} // koniec QuickSortListSorter