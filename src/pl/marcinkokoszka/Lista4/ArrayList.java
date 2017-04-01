package pl.marcinkokoszka.Lista4;

/**
 * Created by kokoseq on 01.04.2017.
 */
public class ArrayList implements List {
    private Object[] array;
    private int size;

    @Override
    public void add(Object o) {
        if(size!=0){
            Object[] temporaryTab= array;
            size++;
            array =new Object[size];
            System.arraycopy(temporaryTab, 0, array, 0, temporaryTab.length);
            array[size-1]=o;
        } else {
            array =new Object[1];
            array[0]=o;
            size++;
        }
    }

    @Override
    public void clear() {
        size=0;
        array =null;
    }

    @Override
    public Object get(int index){
        return array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object delete(int index) throws IndexOutOfBoundsException {
        if (index<0 || index >=size) throw new IndexOutOfBoundsException();
        Object[] temporaryTab= array;
        Object deleted= array[index];
        size--;
        array =new Object [size];
        System.arraycopy(temporaryTab, 0, array, 0, index);
        System.arraycopy(temporaryTab, index+1, array, index, temporaryTab.length-index-1);
        return deleted;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }



}