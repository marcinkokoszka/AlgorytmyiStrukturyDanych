package pl.marcinkokoszka.Lista1.iterators;


import pl.marcinkokoszka.Lista1.iterators.predicates.Predicate;

/**
 * Created by kokoseq on 08.03.2017.
 */
public class FilteringArrayIterator implements Iterator{
    private final Iterator iterator;
    private final Predicate predicate;

    public FilteringArrayIterator(Iterator iterator, Predicate predicate){
        this.iterator = iterator;
        this.predicate = predicate;
    }

    private void filterForward(){
        while (!iterator.isDone() && !predicate.accept(iterator.current()))
            iterator.next();
    }

    private void filterBackwards(){
        while (!iterator.isDone() && !predicate.accept(iterator.current()))
            iterator.previous();
    }

    public void first(){
        iterator.first(); filterForward();
    }

    public void last(){
        iterator.last(); filterBackwards();
    }

    public void next(){
        iterator.next(); filterForward();
    }

    public void previous(){
        iterator.previous(); filterBackwards();
    }

    public boolean isDone(){
        return iterator.isDone();
    }

    public Object current(){
        return iterator.current();
    }

    public void setCurrent(Object o){
        iterator.setCurrent(o);
    }
}
