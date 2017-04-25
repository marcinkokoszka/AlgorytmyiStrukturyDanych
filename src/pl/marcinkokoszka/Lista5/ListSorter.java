package pl.marcinkokoszka.Lista5;

import pl.marcinkokoszka.Lista2.List;

/**
 * Created by kokoseq on 25.04.2017.
 */
public interface ListSorter<T extends Comparable> {
    public List<T> sort(List<T> list); // wynikiem jest lista posortowana
}