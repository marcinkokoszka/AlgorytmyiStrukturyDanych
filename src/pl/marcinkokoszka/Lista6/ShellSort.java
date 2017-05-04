package pl.marcinkokoszka.Lista6;

import pl.marcinkokoszka.Lista4.List;
import pl.marcinkokoszka.Lista5.Comparators.Comparator;
import pl.marcinkokoszka.Lista5.ListSorter;

/**
 * Created by kokoseq on 30.04.2017.
 */
public class ShellSort implements ListSorter {

    private int assignments = 0;
    private int compares = 0;

    private final Comparator _comparator;
    private final int[] _increments = {121, 40, 13, 4, 1}; // przyjęte arbitralnie

    public ShellSort(Comparator comparator) {
        _comparator = comparator;
    }

    public List sort(List list) {
        assert list != null : "Nie określono listy";
        for (int i = 0; i < _increments.length; ++i) {
            int _h = _increments[i];
            hSort(list, _h); // sortowanie podlisty określonej przyrostem _h
        }
        return list;
    }

    private void hSort(List list, int h) {
        if (list.size() < h * 2) {
            return;
        }
        for (int i = 0; i < h; ++i) {
            sortSublist(list, i, h);
        }
    }

    private void sortSublist(List list, int startIndex, int h) {
        for (int i = startIndex + h; i < list.size(); i += h) {
            Object value = list.get(i);
            int j;
            for (j = i; j > startIndex; j -= h) {
                Object previousValue = list.get(j - h);
                compares++;
                if (_comparator.compare(value, previousValue) >= 0) {
                    break;
                }
                list.set(j, previousValue);
                assignments++;
            }
            list.set(j, value);
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
}