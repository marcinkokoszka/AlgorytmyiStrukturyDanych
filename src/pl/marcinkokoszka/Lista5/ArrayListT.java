package pl.marcinkokoszka.Lista5;

import pl.marcinkokoszka.Lista1.iterators.Iterator;
import pl.marcinkokoszka.Lista2.List;

/**
 * Created by kokoseq on 01.04.2017.
 */
public class ArrayListT<T extends Comparable> implements List<T> {
    private T[] array;
    private int size;

    @Override
    public void add(T o) {
        if(size!=0){
            T[] temporaryTab= array;
            size++;
            array = (T[]) new Object [size];
            System.arraycopy(temporaryTab, 0, array, 0, temporaryTab.length);
            array[size-1]=o;
        } else {
            array = (T[]) new Object[1];
            array[0]=o;
            size++;
        }
    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    @Override
    public int indexOf(T value) {
        return 0;
    }

    @Override
    public void clear() {
        size=0;
        array =null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public T get(int index){
        return array[index];
    }

    @Override
    public T set(int index, T value) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(int index, T value) {

    }

    @Override
    public T delete(int index) throws IndexOutOfBoundsException {
        if (index<0 || index >=size) throw new IndexOutOfBoundsException();
        T[] temporaryTab= array;
        T deleted = array[index];
        size--;
        array = (T[]) new Object [size];
        System.arraycopy(temporaryTab, 0, array, 0, index);
        System.arraycopy(temporaryTab, index+1, array, index, temporaryTab.length-index-1);
        return deleted;
    }

    @Override
    public boolean delete(T value) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }




}