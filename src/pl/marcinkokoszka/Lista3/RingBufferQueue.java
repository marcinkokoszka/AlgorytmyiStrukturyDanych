package pl.marcinkokoszka.Lista3;

/**
 * Created by kokoseq on 29.03.2017.
 */
public class RingBufferQueue implements ObjectQueue {
        private Object[] elements = null;

        private int capacity  = 0;
        private int writePos  = 0;
        private int available = 0;

        public RingBufferQueue(int capacity) {
            this.capacity = capacity;
            this.elements = new Object[capacity];
        }

        public void clear() {
            this.writePos = 0;
            this.available = 0;
        }

        public int remainingCapacity() {
            return this.capacity - this.available;
        }

        public boolean enqueue(Object element){

            if(available < capacity){
                if(writePos >= capacity){
                    writePos = 0;
                }
                elements[writePos] = element;
                writePos++;
                available++;
                return true;
            }
            return false;
        }

        public Object dequeue() throws EmptyQueueException{
            if(available == 0){
                throw new EmptyQueueException();
            }
            int nextSlot = writePos - available;
            if(nextSlot < 0){
                nextSlot += capacity;
            }
            Object nextObj = elements[nextSlot];
            available--;
            return nextObj;
        }

        public boolean isEmpty(){
            return remainingCapacity() == capacity;
        }

        public int size(){
            return elements.length;
        }
    }