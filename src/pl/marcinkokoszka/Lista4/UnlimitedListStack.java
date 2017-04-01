package pl.marcinkokoszka.Lista4;

/**
 * Created by kokoseq on 01.04.2017.
 */
public class UnlimitedListStack<T> implements Stack<T>{
    private int size;
    private Element<T> first=new Element<T>(null);

    @Override
    public void push(T o) {
        Element<T> last;
        if(first.getNext()==null){
            first.setNext(new Element<T>(o));
        }
        else{
            last=first.getNext();
            for(int i=1;i<size;i++) last=last.getNext();
            last.setNext(new Element<T>(o));
        }
        ++size;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (size == 0) throw new EmptyStackException();
        Element<T> value=first;
        T delete;
        int index=size-1;
        for (int i=0;i<index;i++){
            value=value.getNext();
        }
        delete=value.getNext().getValue();
        value.setNext(value.getNext().getNext());
        --size;
        return delete;
    }

    @Override
    public T peek() {
        Element <T> value=first;
        int index=size-1;
        for (int i=0;i<=index;i++){
            value=value.getNext();
        }
        return value.getValue();
    }

    @Override
    public void clear() {
        first=new Element<T>(null);
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    private final class Element<T>{
        private T value;
        private Element<T> next;


        Element(T value, Element<T> next){
            this.value=value;
            this.next=next;
        }

        Element(T value){
            this(value, null);

        }

        public T getValue() {
            return value;
        }

        public Element<T> getNext() {
            return next;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(Element<T> next) {
            this.next = next;
        }

    }


}


