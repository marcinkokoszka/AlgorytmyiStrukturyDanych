package pl.marcinkokoszka.Lista4;

import pl.marcinkokoszka.Lista1.iterators.Iterator;

import java.util.Arrays;

/**
 * Created by kokoseq on 01.04.2017.
 */
public class ArrayList implements List {
    private final int _initialCapacity; // bieżąca wielkość tablicy
    private Object [ ] array; // tablica na elementy listy
    private int _size; // bieżąca długość listy
    public ArrayList(int initialCapacity) // konstruktor listy kreujący tablicę o danym rozmiarze
        { assert initialCapacity >0 : "Inicjalny rozmiar tablicy musi być dodatni";
            _initialCapacity = initialCapacity;
            clear();
        }
        public ArrayList() // konstruktor listy kreujący tablicę o domyślnym rozmiarze
        { this(0); }
        public ArrayList(Object [ ] array) // konstruktor listy z wypełnieniem listy elementami tablicy
        { _initialCapacity = array.length;
            clear();
            System.arraycopy(array, 0, this.array, 0, array.length);
            _size = array.length;
        }
        public ArrayList(ArrayList al){
            _initialCapacity = al.array.length;
            this.array = Arrays.copyOf(al.array, al.array.length);
            _size = array.length;
        }
        public void clear() {
            array = new Object[_initialCapacity];
            _size = 0;
        }

        public void insert(int index, Object value) throws IndexOutOfBoundsException {
            if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
            ensureCapacity(_size + 1);
            System.arraycopy(array, index, array, index + 1, _size - index);
            array[index] = value;
            ++_size;
        }
        private void ensureCapacity(int capacity) {
            if (array.length < capacity) { //strategia tworzenia tablicy z 50% zapasem
                Object [ ] copy = new Object[capacity + capacity / 2];
                System.arraycopy(array, 0, copy, 0, _size);
                array = copy; // następuje dynamiczna zmiana rozmiaru tablicy array z elementami listy
            }
        }
        public void add(Object value) {
            insert(size(), value); // add() to szczególny przypadek insert(): wstawienie elementu
// na końcu listy
        }
        public Object get(int index) throws IndexOutOfBoundsException {
            checkOutOfBounds(index);
            return array[index];
        }
        public void set(int index, Object value) throws IndexOutOfBoundsException {
            checkOutOfBounds(index);
            array[index] = value;
        }
        private void checkOutOfBounds(int index) throws IndexOutOfBoundsException {
            if (index < 0 || index >= size()) // kontrola zakresu indeksu dla listy (nie dla tablicy!)
                throw new IndexOutOfBoundsException();
        }

        public int indexOf(Object value) {
            int i =0;
            while(i < _size && !value.equals(array[i])) ++i;
            return i<_size ? i : -1;
        }

        public boolean contains(Object value) {
            return indexOf(value) != -1;
        }

        public boolean isEmpty() {
            return _size == 0; // lub: return size()==0
        }

        public int size() {
            return _size;
        }

        public Object delete(int index) throws IndexOutOfBoundsException {
            checkOutOfBounds(index);
            Object value = array[index];
            int copyFrom = index + 1;
            if (copyFrom < _size)
                System.arraycopy(array, copyFrom,
                        array, index,
                        _size - copyFrom);
            --_size;
            return value;
        }
        public boolean delete(Object value) {
            int index = indexOf(value); // element "przeliczony" na wartość indeksu
            if (index != -1)
                delete(index);
            return index != -1;
        }
        public String toString(){
            return Arrays.toString(array);
        }

    @Override
    public Iterator iterator(){
        return new ArrayIterator();
    }

    private final class ArrayIterator implements Iterator {
        final int first;
        final int last;
        int current = -1;

        public ArrayIterator(){
            first = 0;
            last = array.length - 1;
        }

        public void first(){
            current = first;
        }

        public void last(){
            current = last;
        }

        public void next() {
            ++current;
        }

        public void previous(){
            --current;
        }

        public boolean isDone(){
            return current < first || current > last;
        }

        public Object current(){
            return array[current];
        }
    }

}