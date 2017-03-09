package pl.marcinkokoszka.Lista1.iterators;

/**
 * Created by kokoseq on 08.03.2017.
 */
public class ArrayIterator implements Iterator {
    final Object [ ] array;
    final int first;
    final int last;
    int current = -1;

    public ArrayIterator(Object[] array){
        this.array = array;
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

    public void setCurrent(Object o){
        array[current] = o;
    }

}
