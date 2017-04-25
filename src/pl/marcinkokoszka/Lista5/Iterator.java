package pl.marcinkokoszka.Lista5;

/**
 * Created by kokoseq on 25.04.2017.
 */
public interface Iterator<T extends Comparable> {
    void previous();
    void next();
    void first();
    void last();
    boolean isDone();
    T current();
}