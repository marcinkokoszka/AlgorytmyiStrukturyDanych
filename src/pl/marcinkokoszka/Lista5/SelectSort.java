package pl.marcinkokoszka.Lista5;

import pl.marcinkokoszka.Lista4.List;
import pl.marcinkokoszka.Lista5.Comparators.Comparator;

/**
 * Created by kokoseq on 25.04.2017.
 */
public class SelectSort implements ListSorter, ListSorterCounter {

    private int assignments = 0;
    private int compares = 0;

    private final Comparator _comparator;

    public SelectSort(Comparator comparator) { _comparator = comparator; }

    @Override
    public List sort(List list) {
        int size = list.size();
        for (int slot = 0; slot < size - 1; ++slot) {
            int smallest = slot;
            for (int check = slot + 1; check < size; ++check) {
                compares++;
                if (_comparator.compare(list.get(check), list.get(smallest)) < 0)
                    smallest = check;
            }
            swap(list, smallest, slot);
        }
        return list;
    }

    private void swap(List list, int left, int right) {
        if (left != right) { // sprawdzenie, czy to są dwa różne elementy (czy przestawiać)
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
}