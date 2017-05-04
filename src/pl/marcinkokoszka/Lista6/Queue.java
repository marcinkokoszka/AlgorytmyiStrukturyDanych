package pl.marcinkokoszka.Lista6;

import pl.marcinkokoszka.Lista3.EmptyQueueException;

/**
 * Created by kokoseq on 28.03.2017.
 */
public interface Queue {
        void enqueue(Object value);
        Object dequeue() throws EmptyQueueException;
        void clear();
        int size();
        boolean isEmpty();
}
