package pl.marcinkokoszka.Lista5;

import pl.marcinkokoszka.Lista2.List;

import java.util.Comparator;

/**
 * Created by kokoseq on 25.04.2017.
 */
public class ShakerSort<T extends Comparable> implements ListSorter<T>, ListSorterCounter {

    private int assignments = 0;
    private int compares = 0;

    private final Comparator _comparator;

    public ShakerSort(Comparator comparator) { _comparator = comparator; }

    @Override
    public List<T> sort(List<T> list) {
        int size = list.size();

        for (int i = 0; i < size / 2; i++) {
            boolean swapped = false;

            for (int j = i; j < size - i - 1; j++) {
                compares++;
                if(_comparator.compare(list.get(j), list.get(j+1)) > 0){
//        if (list.get(j) < list.get(j + 1)) {
                    swap(list, j, j+1);
                    assignments++;
                }
            }

            for (int j = size - 2 - i; j > i ; j--) {
                compares++;
                if (_comparator.compare(list.get(j), list.get(j - 1)) < 0) {
                    swap(list, j, j-1);
                    assignments++;
                    swapped = true;
                }
            }

            if(!swapped){
                break;
            }
        }

        return list;
    }

    private void swap(List<T> list, int left, int right) {
        T temp = list.get(left);

        list.set(left, list.get(right));
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
