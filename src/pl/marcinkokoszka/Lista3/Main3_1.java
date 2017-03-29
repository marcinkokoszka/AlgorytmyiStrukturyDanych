package pl.marcinkokoszka.Lista3;

import pl.marcinkokoszka.Lista1.Student;
import pl.marcinkokoszka.Lista2.List;
import pl.marcinkokoszka.Lista2.Main1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kokoseq on 28.03.2017.
 */
public class Main3_1 {

    public static void main(String[] args) {
        System.out.println("Utworzenie nowej kolejki studentów.\n");
        FIFOQueueDirectImplementation<Student> q = new FIFOQueueDirectImplementation<>();

        System.out.println("Dodanie 5 studentów do kolejki:");
        Student s1 = new Student("Kowalski", "Jan", 111111, 5.0);
        Student s2 = new Student("Nowak", "Mateusz", 222222, 4.0);
        Student s3 = new Student("Bombastyczny", "Natan", 333333, 4.0);
        Student s4 = new Student("Koliweszka", "Urszula", 444444, 3.0);
        Student s5 = new Student("Kucia", "Kasia", 555555, 2.0);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println();
        q.enqueue(s1);
        q.enqueue(s2);
        q.enqueue(s3);
        q.enqueue(s4);
        q.enqueue(s5);


        System.out.println("Rozmiar kolejki:");
        System.out.println(q.size());

        System.out.println();
        try {
            System.out.println("Pierwszy student z kolejki:");
            System.out.println(q.dequeue());
            System.out.println("\nDrugi student z kolejki:");
            System.out.println(q.dequeue());
            System.out.println("\nTrzeci student z kolejki:");
            System.out.println(q.dequeue());
            System.out.println("\nCzwarty student z kolejki:");
            System.out.println(q.dequeue());
            System.out.println("\nCzwarty student z kolejki:");
            System.out.println(q.dequeue());
            System.out.println("\nPróba odczytania studenta z pustej kolejki:");
            System.out.println(q.dequeue());
        } catch (EmptyQueueException e) {
            System.out.println("EmptyQueueException. Kolejka pusta.");
        }

        System.out.println();
        System.out.println("Dodanie 100 studentów do kolejki z pliku tekstowego.");
        q = readStudentsFromTxt();

        System.out.println();
        try {
            System.out.println("1. student z kolejki:");
            System.out.println(q.dequeue());
            Student mk = new Student("Kokoszka", "Marcin", 169472, 4.5);
            System.out.println("\nDodanie studenta " + mk + " do kolejki.\n");
            q.enqueue(mk);
            int n = q.size();
            for (int i = 0; i < n - 1; i++) {
                System.out.println((i + 2) + ". student z kolejki:");
                System.out.println(q.dequeue());
            }
            System.out.println("Dodany student z kolejki:");
            System.out.println(q.dequeue());
        } catch (EmptyQueueException e) {
            System.out.println("EmptyQueueException. Kolejka pusta.");
        }

        System.out.println();
        System.out.println("Dodanie 100 studentów do kolejki z pliku tekstowego.");
        q = readStudentsFromTxt();
        System.out.println("Rozmiar kolejki: " + q.size());

        System.out.println();
        System.out.println("Wyczyszczenie kolejki.");
        q.clear();
        System.out.println("Rozmiar kolejki:" + q.size());
        System.out.println("\nPróba odczytania studenta z pustej kolejki: ");
        try {
            q.dequeue();
        } catch (EmptyQueueException e) {
            System.out.println("EmptyQueueException. Kolejka pusta.");
        }

        System.out.println("\nCzy kolejka jest pusta?: " + q.isEmpty());
    }

    public static FIFOQueueDirectImplementation<Student> readStudentsFromTxt() {
        try (FileReader fr = new FileReader("Studenci.txt");
             BufferedReader br = new BufferedReader(fr)) {

            FIFOQueueDirectImplementation<Student> students = new FIFOQueueDirectImplementation<>();
            String line;
            String[] dataFromLine;

            while ((line = br.readLine()) != null) {
                dataFromLine = line.split(";");
                students.enqueue((new Student(dataFromLine[0], dataFromLine[1], Integer.parseInt(dataFromLine[2]), Double.parseDouble(dataFromLine[3]))));
            }

            return students;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
