package pl.marcinkokoszka.Lista3;

/**
 * Created by kokoseq on 29.03.2017.
 */
public class FIFOQueueDirectImplementation<T extends Comparable> implements Queue<T> {
    private Element<T> first;
    private Element<T> last;
    private int size;
    private int maxSize = 100;

    public FIFOQueueDirectImplementation(){
        first = null;
        clear();
    }

    public void clear(){
        first = null;
        last = null;
        size=0;
    }

    public void setMaxSize(int maxSize){
        this.maxSize = maxSize;
    }

    public void enqueue(T value) {
        if (size == maxSize) return;
        if (first == null){
            first = new Element<>(value);
            last = first;
        }
        else {
            last.next = new Element<>(value);
            last = last.next;
        }
        size++;
    }

    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        Element<T> e = first;
        first = first.getNext();
        size--;
        return e.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        return first.toString();
    }

private final class Element<T extends Comparable>{
    private T value;
    private Element<T> next = null;

    Element(T value){
        this.value = value;
    }

    T getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }

    Element<T> getNext() {
        return next;
    }

    void setNext(Element<T> next) {
        this.next = next;
    }

    public String toString(){
        return value.toString();
    }
}
}