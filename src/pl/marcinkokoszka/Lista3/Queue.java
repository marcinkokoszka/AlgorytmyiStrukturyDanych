package pl.marcinkokoszka.Lista3;

/**
 * Created by kokoseq on 28.03.2017.
 */
public interface Queue<T extends Comparable> {
        void enqueue(T value);
        T dequeue() throws EmptyQueueException;
        void clear();
        int size();
        boolean isEmpty();
}
