package pl.marcinkokoszka.Lista5;

import pl.marcinkokoszka.Lista4.List;

/**
 * Created by kokoseq on 25.04.2017.
 */
public interface ListSorter extends ListSorterCounter {
    List sort(List list); // wynikiem jest lista posortowana
}