package pl.marcinkokoszka.Lista3;

/**
 * Created by kokoseq on 01.04.2017.
 */
public class ArrayStack<T> implements Stack<T> {
        private T[] arr = null;
        private int CAP;
        private int top = -1;
        private int size = 0;

        @SuppressWarnings("unchecked")
        public ArrayStack(int cap) {
            this.CAP = cap;
            this.arr = (T[]) new Object[cap];
        }

        public T pop() {
            if(this.size == 0){
                return null;
            }

            this.size--;
            T result = this.arr[top];
            this.arr[top] = null;//prevent memory leaking
            this.top--;

            return result;
        }

        public void push(T t) {
            if (!isFull()) return;
            this.size++;
            this.arr[++top] = t;
        }

        public boolean isFull() {
            if (this.size == this.CAP)
                return false;
            return true;
        }

        public String toString() {
            if(this.size==0){
                return null;
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<this.size; i++){
                sb.append(this.arr[i] + ", ");
            }

            sb.setLength(sb.length()-2);
            return sb.toString();
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public void clear(){
            size = 0;

        }

}
