package pl.marcinkokoszka.Lista4;

/**
 * Created by kokoseq on 01.04.2017.
 */
public interface List {
    void add(Object o);
    void clear();
    int size();
    Object delete (int index) throws IndexOutOfBoundsException;
    Object get(int index) throws IndexOutOfBoundsException;
    boolean isEmpty();
}