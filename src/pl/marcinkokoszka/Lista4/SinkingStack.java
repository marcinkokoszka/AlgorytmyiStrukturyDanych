package pl.marcinkokoszka.Lista4;

/**
 * Created by kokoseq on 01.04.2017.
 */
public class SinkingStack implements Stack {
    private ArrayList list = new ArrayList();
    private int maxSize;

    public SinkingStack (int maxSize){
        this.maxSize=maxSize;
    }

    @Override
    public void push(Object o) {
        if(list.size()==maxSize){
            list.delete(0);
            list.add(o);
        } else {
            list.add(o);
        }
    }

    @Override
    public Object pop() throws EmptyStackException {
        if (list.size() == 0) throw new EmptyStackException();
        return list.delete(list.size()-1);
    }

    @Override
    public Object peek() {
        return list.get(list.size()-1);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

}