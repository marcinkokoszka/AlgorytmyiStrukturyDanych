package pl.marcinkokoszka.Lista2;

import pl.marcinkokoszka.Lista1.Student;
import pl.marcinkokoszka.Lista1.iterators.Iterator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kokoseq on 23.03.2017.
 */
public class Main2 {

    public static void main(String[] args) {

        DoublyLinkedList lista1 = readStudentsFromTxt();
        DoublyLinkedList lista2 = new DoublyLinkedList();

        System.out.println("ZADANIE 2");
        System.out.println();
        System.out.println("Wszyscy studenci na liście 1:");
        printList(lista1.iterator());

        lista2.add(lista1.get(97));
        lista2.add(lista1.get(98));
        lista2.add(lista1.get(99));
        System.out.println();
        System.out.println("Wszyscy studenci na liście 2:");
        printList(lista2.iterator());

        System.out.println();
        System.out.println("Dodanie listy drugiej do pierwszej na pozycji 6.");
        insertByIndex(lista1, lista2, 5);
        System.out.println();
        System.out.println("Wszyscy studenci na liście 1:");
        printList(lista1.iterator());

        System.out.println();
        System.out.println("Dodanie listy drugiej do pierwszej na pozycji Natalii Krasowskiej.");
        insertByValue(lista1, lista2, lista1.get(5));
        System.out.println();
        System.out.println("Wszyscy studenci na liście 1:");
        printList(lista1.iterator());

        System.out.println();
        System.out.println("Dodanie listy drugiej do pierwszej na koniec.");
        append(lista1, lista2);
        System.out.println();
        System.out.println("Wszyscy studenci na liście 1:");
        printList(lista1.iterator());
    }

    private static void insertByIndex(DoublyLinkedList l1, DoublyLinkedList l2, int index){
        Iterator il2 = l2.iterator();

        int i = 0;
        for (il2.first();!il2.isDone();il2.next()){
            l1.insert(index + i, il2.current());
            i++;
        }
    }

    private static void insertByValue(DoublyLinkedList l1, DoublyLinkedList l2, Object value){
        Iterator il2 = l2.iterator();

        int index = l1.indexOf(value);
        int i = 0;
        for (il2.first();!il2.isDone();il2.next()){
            l1.insert(index + i, il2.current());
            i++;
        }
    }

    private static void append(DoublyLinkedList l1, DoublyLinkedList l2){
        Iterator il2 = l2.iterator();

        int index = l1.size();
        int i = 0;
        for (il2.first();!il2.isDone();il2.next()){
            l1.insert(index + i, il2.current());
            i++;
        }
    }

    private static void printList(Iterator iterator){
        iterator.first();
        while(!iterator.isDone()){
            System.out.println(iterator.current());
            iterator.next();
        }
    }

    private static DoublyLinkedList readStudentsFromTxt(){
        try (FileReader fr = new FileReader("Studenci.txt");
             BufferedReader br = new BufferedReader(fr)){

            DoublyLinkedList students = new DoublyLinkedList();
            String line;
            String[] dataFromLine;

            while ((line = br.readLine()) != null) {
                dataFromLine = line.split(";");
                students.add((new Student(dataFromLine[0], dataFromLine[1], Integer.parseInt(dataFromLine[2]), Double.parseDouble(dataFromLine[3]))));
            }

            return students;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
