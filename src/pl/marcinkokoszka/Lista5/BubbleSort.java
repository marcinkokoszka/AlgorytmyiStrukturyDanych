package pl.marcinkokoszka.Lista5;

import java.util.Comparator;
import pl.marcinkokoszka.Lista2.List;

/**
 * Created by kokoseq on 25.04.2017.
 */

public class BubbleSort<T extends Comparable> implements ListSorter<T>, ListSorterCounter {

    private int assignments = 0;
    private int compares = 0;

    private final Comparator _comparator;

    public BubbleSort(Comparator comparator) { _comparator = comparator; }

    @Override
    public List<T> sort(List<T> list) {
        int lastSwap = list.size() - 1;
        while(lastSwap > 0){
            int end = lastSwap;
            lastSwap = 0;
            for (int left = 0; left < end; ++left) {
                compares++;
                if (_comparator.compare(list.get(left), list.get(left+1)) > 0)
                {
                    T temp=list.get(left);
                    while(left<end && _comparator.compare(temp, list.get(left+1)) > 0)
                    {
                        list.set(left, list.get(left+1));
                        left++;

                        compares++;
                        assignments++;
                    }
                    lastSwap = left;
                    list.set(left, temp);
                    assignments++;
                }
            }
        }
        return list;
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