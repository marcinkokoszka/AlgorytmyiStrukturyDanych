package pl.marcinkokoszka.Lista4;

/**
 * Created by kokoseq on 01.04.2017.
 */
public class ArrayStack<T> implements Stack<T> {
    private T[] array = null;
    private int cap;
    private int top = -1;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public ArrayStack(int cap) {
        this.cap = cap;
        this.array = (T[]) new Object[cap];
    }

    @Override
    public T pop() throws EmptyStackException {
        if(this.size == 0){
            throw new EmptyStackException();
        }
        this.size--;
        T result = this.array[top];
        this.array[top] = null;
        this.top--;

        return result;
    }

    @Override
    public T peek() throws EmptyStackException {
        if(this.size == 0){
            return null;
        }
        return this.array[top];
    }

    @Override
    public void push(T t) {
        if (!isFull()) return;
        this.size++;
        this.array[++top] = t;
    }

    public boolean isFull() {
        return this.size != this.cap;
    }

    @Override
    public String toString() {
        if(this.size==0){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<this.size; i++){
            sb.append(this.array[i] + ", ");
        }

        sb.setLength(sb.length()-2);
        return sb.toString();
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear(){
        size = 0;
        this.array = (T[]) new Object[cap];
    }

    @Override
    public int size() {
        return size;
    }

}
