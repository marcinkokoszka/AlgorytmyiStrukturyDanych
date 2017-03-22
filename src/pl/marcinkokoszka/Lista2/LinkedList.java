package pl.marcinkokoszka.Lista2;

import pl.marcinkokoszka.Lista1.iterators.Iterator;

/**
 * Created by kokoseq on 15.03.2017.
 */
public class LinkedList<T> implements List<T> {
    private Element<T> first;
    private int size;

    public LinkedList(){
        first = null;
        clear();
    }

    public void clear(){
        first = null;
        size=0;
    }

    public int size(){
        return size;
    }

    public void insert(int index, T value){

        Element<T> tempElement = new Element<>(value);
        Element<T> currentElement = first;

        if (currentElement != null) {
            for (int i = 0; i < index - 1 && currentElement.getNext() != null; i++) {
                currentElement = currentElement.getNext();
            }
            tempElement.setNext(currentElement.getNext());
            currentElement.setNext(tempElement);
        } else {
            first = tempElement;
        }
        size++;
    }

    public T get(int index) throws IndexOutOfBoundsException{
        checkOutOfBounds(index);
        return getElement(index).getValue();
    }

    private Element<T> getElement(int index){
        Element<T> element = first;
        for (int i = index; i > 0; i--){
            element = element.getNext();
        }
        return element;
    }

    private void checkOutOfBounds(int index) throws IndexOutOfBoundsException{
        if(index<0 || index>size) throw new IndexOutOfBoundsException();
    }

    public T set(int index, T value) throws IndexOutOfBoundsException{
        checkOutOfBounds(index);
        Element<T> element = getElement(index);
        T oldValue = element.getValue();
        element.setValue(value);
        return oldValue;
    }

    public void add(T value){
        insert(size(), value);
    }

    public T delete(int index) throws IndexOutOfBoundsException{
        checkOutOfBounds(index);
        Element<T> element = getElement(index);
        if (index == 0) first = (first.getNext());
        else getElement(index - 1).setNext(element.getNext());
        element.setNext(element);
        size--;
        return element.getValue();
    }

    public boolean delete(T value){
        if(first == null) return false;
        if(first.getValue().equals(value)){
            first = (first.getNext());
            size--;
            return true;
        }

        Element<T> delete = first;
        while(delete != null && delete.getNext() != null){
            if(delete.getNext().getValue().equals(value)){
                delete.setNext(delete.getNext().getNext());
                size--;
                return true;
            }
            delete = delete.getNext();
        }
        return false;
    }

    public int indexOf(T value){
        int index = 0;
        Element<T> e = first;
        while (e != null && !value.equals(e.getValue())){
            e = e.getNext();
            index++;
        }
        if (e == null) return -1;
        return index;
    }

    public boolean contains(T value){
        return indexOf(value) != -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Iterator iterator(){
        return new ValueIterator();
    }

    private static final class Element<T>{
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

    private final class ValueIterator implements Iterator {
        private Element<T> current = first;

        public void first(){
            current = first;
        }

        public void last(){
            current = getElement(size());
        }

        public boolean isDone(){
            return current == null;
        }

        public void next(){
            current = current.getNext();
        }

        public void previous(){
            current = getElement(indexOf(current.getValue()) - 1);
        }

        public T current() throws IndexOutOfBoundsException{
            if (isDone()) throw new IndexOutOfBoundsException();
            return current.getValue();
        }
    }
}
