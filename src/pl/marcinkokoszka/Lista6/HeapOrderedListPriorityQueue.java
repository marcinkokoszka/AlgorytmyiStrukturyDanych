package pl.marcinkokoszka.Lista6;

import pl.marcinkokoszka.Lista3.EmptyQueueException;
import pl.marcinkokoszka.Lista4.ArrayList;
import pl.marcinkokoszka.Lista4.List;
import pl.marcinkokoszka.Lista5.Comparators.Comparator;
import pl.marcinkokoszka.Lista5.ListSorterCounter;

/**
 * Created by kokoseq on 30.04.2017.
 */

public class HeapOrderedListPriorityQueue implements Queue, ListSorterCounter {

    private final List _list;

    private final Comparator _comparator;

    private int assignments = 0;
    private int compares = 0;

    public HeapOrderedListPriorityQueue(Comparator comparator) {
        _comparator = comparator;
        _list = new ArrayList();
    }

    public void enqueue(Object value) {
       _list.add(value); swim(_list.size() - 1); // wynurzenie (wyniesienie) elementu
    }

    private void swim(int index) {
        int parent;
        while (index != 0 && _comparator.compare(_list.get(index), _list.get(parent = (index - 1) / 2)) > 0) {
            compares++;
            swap(index, parent);
            index = parent;
        }
    }

    private void swap(int index1, int index2) {
        Object temp = _list.get(index1);
        _list.set(index1, _list.get(index2));
        assignments++;
        _list.set(index2, temp);
        assignments++;
    }

    public Object dequeue() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        Object result = _list.get(0);
        if (_list.size() > 1) {
            _list.set(0, _list.get(_list.size() - 1));
            sink(0);
        }
        _list.delete(_list.size() - 1); return result;
    }

    private void sink(int index) {
        boolean isDone=false;
        int child;
        while(!isDone && (child=2*index+ 1 ) < _list.size()) {
            if (child < _list.size()-1 && _comparator.compare(_list.get(child), _list.get(child+1)) < 0)
                ++child;
            if (_comparator.compare(_list.get(index), _list.get(child)) < 0)
                swap(index, child); else isDone=true; index = child;
        }
    }

    public void clear() {
        _list.clear();
    }

    public int size() {
        return _list.size();
    }

    public boolean isEmpty() {
        return _list.isEmpty();
    }

    @Override
    public int getAssignments() {
        return assignments;
    }

    @Override
    public int getCompares() {
        return compares;
    }

    @Override
    public void setAssignments(int assignments) {
        this.assignments = assignments;
    }

    @Override
    public void setCompares(int compares) {
        this.compares = compares;
    }
}
