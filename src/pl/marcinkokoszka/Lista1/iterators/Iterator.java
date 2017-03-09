package pl.marcinkokoszka.Lista1.iterators;

/**
 * Created by kokoseq on 08.03.2017.
 */
public interface Iterator {
    void previous();
    void next();
    void first();
    void last();
    void setCurrent(Object o);
    boolean isDone();
    Object current();
}
