package pl.marcinkokoszka.Lista2;

import pl.marcinkokoszka.Lista1.Student;
import pl.marcinkokoszka.Lista1.iterators.Iterator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kokoseq on 14.03.2017.
 */
public class Main1 {

    public static void main(String[] args) {

        LinkedList<Student> lls = readStudentsFromTxt();

        System.out.println("ZADANIE 1");
        System.out.println();
        System.out.println("Wszyscy studenci na liście:");
        printList(lls.iterator());

        System.out.println();
        System.out.println("Ilość elementów listy: " + lls.size());

        System.out.println();
        System.out.println("Dodanie studenta na 3 miejsce w liście:");
        Student mk = new Student("MARCIN", "KOKOSZKA", 169472, 4.5);
        System.out.println(mk);
        System.out.println();
        lls.insert(2, mk);
        System.out.println("Wszyscy studenci po dodaniu:");
        printList(lls.iterator());

        System.out.println();
        System.out.println("Usunięcie studenta:");
        System.out.println(mk);
        System.out.println();
        lls.delete(mk);
        System.out.println("Wszyscy studenci po usunięciu:");
        printList(lls.iterator());

        System.out.println();
        System.out.println("Dodanie studenta na koniec listy:");
        System.out.println(mk);
        System.out.println();
        lls.add(mk);
        System.out.println("Wszyscy studenci po dodaniu:");
        printList(lls.iterator());

        System.out.println();
        System.out.println("Usunięcie studenta na pozycji 101:");
        System.out.println();
        lls.delete(100);
        System.out.println("Wszyscy studenci po usunięciu:");
        printList(lls.iterator());

        System.out.println();
        System.out.println("Student z pozycji 6:");
        System.out.println(lls.get(5));

        System.out.println();
        System.out.println("Ustawienie studenta " + mk + " na pozycji 6:");
        System.out.println("Zamiana z: " + lls.set(5, mk));
        System.out.println("Wszyscy studenci po ustawieniu:");
        printList(lls.iterator());

        System.out.println();
        System.out.println("Czy lista zawiera studenta " + mk + "?");
        System.out.println(lls.contains(mk));

        System.out.println();
        System.out.println("Pozycja studenta " + mk + ":");
        System.out.println(lls.indexOf(mk) + 1);

        System.out.println();
        System.out.println("Czy lista jest pusta?");
        System.out.println(lls.isEmpty());

        System.out.println();
        System.out.println("Czyszczenie listy");
        lls.clear();
        System.out.println("Czy lista teraz jest pusta?");
        System.out.println(lls.isEmpty());
    }

    private static void printList(Iterator iterator){
        while(!iterator.isDone()){
            System.out.println(iterator.current());
            iterator.next();
        }
    }

    private static LinkedList<Student> readStudentsFromTxt(){
        try (FileReader fr = new FileReader("Studenci.txt");
             BufferedReader br = new BufferedReader(fr)){

            LinkedList<Student> students = new LinkedList<>();
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
