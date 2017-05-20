package pl.marcinkokoszka.Lista7;

import java.util.Comparator;

/**
 * Created by kokoseq on 20.05.2017.
 */
public class NaturalComparator<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return ((Comparable<T>)o1).compareTo(o2);
    }
}
