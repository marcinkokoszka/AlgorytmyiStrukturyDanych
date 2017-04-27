package pl.marcinkokoszka.Lista5;

import pl.marcinkokoszka.Lista4.List;
import pl.marcinkokoszka.Lista5.Comparators.Comparator;

/**
 * Created by kokoseq on 25.04.2017.
 */
public class ShakerSort implements ListSorter, ListSorterCounter {

    private int assignments = 0;
    private int compares = 0;

    private final Comparator _comparator;

    public ShakerSort(Comparator comparator) { _comparator = comparator; }

    @Override
    public List sort(List list) {
        int size = list.size();

        for (int i = 0; i < size / 2; i++) {
            boolean swapped = false;

            for (int j = i; j < size - i - 1; j++) {
                compares++;
                if(_comparator.compare(list.get(j), list.get(j+1)) > 0){
                    swap(list, j, j+1);
                }
            }

            for (int j = size - 2 - i; j > i ; j--) {
                compares++;
                if (_comparator.compare(list.get(j), list.get(j - 1)) < 0) {
                    swap(list, j, j-1);
                    swapped = true;
                }
            }

            if(!swapped){
                break;
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
