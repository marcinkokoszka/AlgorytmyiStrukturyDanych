package pl.marcinkokoszka.Lista4;

/**
 * Created by kokoseq on 01.04.2017.
 */
public interface Stack<T> {
    void push(T value);
    T pop() throws EmptyStackException;
    T peek() throws EmptyStackException;
    void clear();
    int size();
    boolean isEmpty();
}
