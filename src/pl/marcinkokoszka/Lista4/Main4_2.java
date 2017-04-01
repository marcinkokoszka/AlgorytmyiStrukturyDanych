package pl.marcinkokoszka.Lista4;

import pl.marcinkokoszka.Lista1.Student;

/**
 * Created by kokoseq on 28.03.2017.
 */
public class Main4_2 {

    public static void main(String[] args) {
        System.out.println("Utworzenie nowego stosu studentów.\n");
        UnlimitedListStack<Student> q = new UnlimitedListStack<>();

        System.out.println("Dodanie 5 studentów do stosu:");
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
        q.push(s1);
        q.push(s2);
        q.push(s3);
        q.push(s4);
        q.push(s5);

        System.out.println("Zdjęcie studenta ze stosu:");
        System.out.println(q.pop());

        System.out.println();
        System.out.println("Podglądnięcie studenta na stosie:");
        System.out.println(q.peek());

        System.out.println();
        System.out.println("Rozmiar stosu:");
        System.out.println(q.size());

        System.out.println();
        System.out.println("Dodanie 1 studenta do stosu i zdjęcie go:");
        q.push(s1);
        System.out.println(q.pop());


        System.out.println();
        System.out.println("Wyczyszczenie stosu.");
        q.clear();
        System.out.println("Rozmiar stosu " + q.size());
        System.out.println("\nPróba odczytania studenta z pustego stosu: ");
        try {
            q.pop();
        } catch (EmptyStackException e) {
            System.out.println("EmptyStackException. Stos pusty.");
        }

        System.out.println("\nCzy stos jest pusty?: " + q.isEmpty());
    }
}
