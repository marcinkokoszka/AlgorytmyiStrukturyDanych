package pl.marcinkokoszka.Lista4;

/**
 * Created by kokoseq on 01.04.2017.
 */
public class ChangingStack implements Stack{
    private ArrayList list=new ArrayList();
    private int maxSize;

    public ChangingStack(int maxSize){
        this.maxSize=maxSize;
    }

    @Override
    public void push(Object o) {
        list.add(o);
        changeSize();
    }

    public int getSize(){
        return maxSize;
    }

    @Override
    public Object pop() throws EmptyStackException {
        if (list.size() == 0) throw new EmptyStackException();
        Object o=list.delete(list.size()-1);
        changeSize();
        return o;
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

    private void changeSize(){
        if(list.size()>=(maxSize*3/4)) maxSize*=2;
        if(list.size()<=(maxSize/4)) maxSize/=2;
    }

}
