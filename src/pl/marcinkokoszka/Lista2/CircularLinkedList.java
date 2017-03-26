package pl.marcinkokoszka.Lista2;

/**
 * Created by kokoseq on 23.03.2017.
 */
public class CircularLinkedList {
    private Element start;
    private int size;

    public void add(int x){
        size++;
        Element temp=new Element(x);
        if(start==null){
            start=temp;
        }else{
            Element tp=start;
            while(tp.next !=start){
                tp=tp.next;
            }
            tp.next =temp;
        }
        temp.next =start;
    }

    public void displayList(){
        if(start==null)
            System.out.println("List jest pusta.");
        else{
            Element temp=start;
            System.out.print("->");
            while(temp.next !=start){
                System.out.println(" "+temp.data);
                temp=temp.next;
            }
            System.out.println(temp.data+" ->");
        }
    }

    public int delete(Element element){
        Element current=start;
        Element previous=start;
        int data= element.data;
        while(current.data!=data){
            if(current.next ==start)
                break; // Element does not exists in circular linked list
            previous=current;
            current=current.next;
        }
        previous.next =current.next;
        size--;
        return data;//returning the deleted data
    }

    public int getSize(){
        return size;
    }

    /* Extra method for Main3 problem */
    public void game(int countToDeath){

        Element current=new Element(0, start);

        while(size > 0){
            for(int i=0;i<countToDeath;i++){
                current=current.next;
            }

            if(size>2){
                System.out.println("Ginie osoba nr:" + delete(current));
            }else if(size == 2) {
                System.out.println("Przeżywa Flawiusz - osoba nr:" + delete(current));
            } else {
                System.out.println("Przeżywa kolega Flawiusza - osoba nr:" + current.data);
                break;
            }
            start=current;
            current=start;
        }
    }
    private static class Element {
        int data;
        Element next;

        public Element(int data){
            this.data=data;
        }
        @SuppressWarnings("unused")
        public Element(int data, Element next){
            this.data=data;
            this.next = next;
        }
    }
}