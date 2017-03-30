package pl.marcinkokoszka.Lista3;

import pl.marcinkokoszka.Lista2.LinkedList;
import pl.marcinkokoszka.Lista2.List;

/**
 * Created by kokoseq on 28.03.2017.
 */
public class FIFOQueue<T extends Comparable> {

    private final List<T> list;

    public FIFOQueue(List list) {
        this.list = list;
    }

    public FIFOQueue(){
        this(new LinkedList());
    }

    public boolean enqueue(T value) {
        list.add(value);
        return true;
    }

    public Object dequeue() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        return list.delete(0);
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString() {
        return list.toString();
    }
}
