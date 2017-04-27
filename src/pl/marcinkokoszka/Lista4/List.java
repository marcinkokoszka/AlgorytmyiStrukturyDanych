package pl.marcinkokoszka.Lista4;

import pl.marcinkokoszka.Lista1.iterators.Iterator;

/**
 * Created by kokoseq on 01.04.2017.
 */
public interface List {
    void add(Object o);
    void insert(int index, Object value);
    void clear();
    int size();
    Object delete (int index) throws IndexOutOfBoundsException;
    Object get(int index) throws IndexOutOfBoundsException;
    boolean isEmpty();
    void set(int index, Object o);
    Iterator iterator();
}