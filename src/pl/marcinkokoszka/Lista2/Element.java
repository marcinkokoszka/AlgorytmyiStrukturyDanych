package pl.marcinkokoszka.Lista2;

/**
 * Created by kokoseq on 15.03.2017.
 */
public class Element<T> {
    private T value;
    private Element next;

    public Element(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }


}
