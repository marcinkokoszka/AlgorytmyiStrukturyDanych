package pl.marcinkokoszka.Lista2;

import pl.marcinkokoszka.Lista1.iterators.Iterator;

/**
 * Created by kokoseq on 15.03.2017.
 */
public interface List<T extends Comparable> extends Iterable {

    int size();
    void insert(int index, T value);
    T delete(int index);
    boolean delete(T value);
    T get(int index) throws IndexOutOfBoundsException;
    T set(int index, T value) throws IndexOutOfBoundsException;
    void add(T value);
    boolean contains(T value);
    int indexOf(T value);
    boolean isEmpty();
    void clear();
    Iterator iterator();
}
