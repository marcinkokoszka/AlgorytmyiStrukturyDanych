package pl.marcinkokoszka.Lista3;

import pl.marcinkokoszka.Lista1.Student;

/**
 * Created by kokoseq on 29.03.2017.
 */
public class Main3_2 {
    public static void main(String[] args) {
        System.out.println("Utworzenie nowego bufora cyklicznego o wielkości 4.\n");
        RingBufferQueue rbq = new RingBufferQueue(4);

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
        rbq.enqueue(s1);
        rbq.enqueue(s2);
        rbq.enqueue(s3);
        rbq.enqueue(s4);
        rbq.enqueue(s5);


        System.out.println("Rozmiar bufora:");
        System.out.println(rbq.size());

        System.out.println();
        try {
            System.out.println("Pierwszy student z kolejki:");
            System.out.println(rbq.dequeue());
            System.out.println("\nDrugi student z kolejki:");
            System.out.println(rbq.dequeue());
            System.out.println("\nTrzeci student z kolejki:");
            System.out.println(rbq.dequeue());
            System.out.println("\nCzwarty student z kolejki:");
            System.out.println(rbq.dequeue());
            System.out.println("\nPiąty student z kolejki:");
            System.out.println(rbq.dequeue());
            System.out.println("\nPróba odczytania studenta z pustej kolejki:");
            System.out.println(rbq.dequeue());
        } catch (EmptyQueueException e) {
            System.out.println("EmptyQueueException. Kolejka pusta.");
        }

        System.out.println();
        System.out.println("Dodanie 5 studentów do kolejki.");
        rbq.enqueue(s1);
        rbq.enqueue(s2);
        rbq.enqueue(s3);
        rbq.enqueue(s4);
        rbq.enqueue(s5);

        System.out.println();
        try {
            System.out.println("1. student z kolejki:");
            System.out.println(rbq.dequeue());
            Student mk = new Student("Kokoszka", "Marcin", 169472, 4.5);
            System.out.println("\nDodanie studenta " + mk + " do kolejki.\n");
            rbq.enqueue(mk);
            int n = rbq.size();
            for (int i = 0; i < n - 1; i++) {
                System.out.println((i + 2) + ". student z kolejki:");
                System.out.println(rbq.dequeue());
            }
            System.out.println("Dodany student z kolejki:");
            System.out.println(rbq.dequeue());
        } catch (EmptyQueueException e) {
            System.out.println("EmptyQueueException. Kolejka pusta.");
        }

        System.out.println();
        System.out.println("Dodanie 5 studentów do kolejki.");
        rbq.enqueue(s1);
        rbq.enqueue(s2);
        rbq.enqueue(s3);
        rbq.enqueue(s4);
        rbq.enqueue(s5);
        System.out.println("Rozmiar kolejki: " + rbq.size());

        System.out.println();
        System.out.println("Wyczyszczenie kolejki.");
        rbq.clear();
        System.out.println("Rozmiar kolejki:" + rbq.size());
        System.out.println("\nPróba odczytania studenta z pustej kolejki: ");
        try {
            rbq.dequeue();
        } catch (EmptyQueueException e) {
            System.out.println("EmptyQueueException. Kolejka pusta.");
        }

        System.out.println("\nCzy kolejka jest pusta?: " + rbq.isEmpty());
    }
}
