package pl.marcinkokoszka.Lista3;

/**
 * Created by kokoseq on 28.03.2017.
 */
public interface ObjectQueue {
        boolean enqueue(Object value);
        Object dequeue() throws EmptyQueueException;
        void clear();
        int size();
        boolean isEmpty();
}
