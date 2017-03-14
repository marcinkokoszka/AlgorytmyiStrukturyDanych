package pl.marcinkokoszka.Lista1;

import pl.marcinkokoszka.Lista1.iterators.*;
import pl.marcinkokoszka.Lista1.iterators.predicates.NegativeGradePredicate;
import pl.marcinkokoszka.Lista1.iterators.predicates.PositiveGradePredicate;
import pl.marcinkokoszka.Lista1.iterators.predicates.Predicate;

public class Main {
    public static StudentList sl;

    public static void main(String[] args) {

        sl = new StudentList();

        showAllStudents();
        System.out.println();

        showAllStudentsWithNegativeGrade();
        System.out.println();

        averagePositiveGrade();
        System.out.println();

        showAllStudentsWithPositiveGradeAboveAverage();
        System.out.println();

        showAllStudentsWithPositiveGradeBelowAverage();
        System.out.println();

        System.out.println("Ustawienie oceny 3.0 dla studenta o albumie 807834");
        setGradeByIndexNo(807834, 3.0);
        System.out.println();

        System.out.println("Dodanie studenta: KOKOSZKA MARCIN, 169472, 4.5");
        addStudent(new Student("KOKOSZKA", "MARCIN", 169472, 4.5));
        System.out.println();

        showAllStudents();
        System.out.println();

        System.out.println("Usunięcie studenta o indeksie 169472");
        removeStudent(169472);
        System.out.println();

        showAllStudents();
        System.out.println();

        System.out.println("Porządkowanie studentów według malejących ocen");
        bubbleSortStudents();
        System.out.println();

        showAllStudents();
        System.out.println();
    }

    public static void showAllStudents() {
        ArrayIterator ai = new ArrayIterator(sl.getStudents());
        System.out.println("Lista wszystkich studentów:");
        sl.showStudents(ai);
    }

    public static void setGradeByIndexNo(int indexNo, double grade) {
        ArrayIterator ai = new ArrayIterator(sl.getStudents());
        Predicate p = new Predicate(){
            @Override
            public boolean accept(Object o) {
                return ((Student)o).getIndexNo() == indexNo;
            }
        };
        FilteringArrayIterator fai = new FilteringArrayIterator(ai, p);
        sl.setGrade(fai, grade);

    }

    public static void averagePositiveGrade() {
        ArrayIterator ai = new ArrayIterator(sl.getStudents());
        Predicate p = new PositiveGradePredicate();
        FilteringArrayIterator fai = new FilteringArrayIterator(ai, p);
        System.out.println("średnia ocen studentów, którzy zaliczyli kurs:");
        System.out.println(sl.averageGrade(fai));
    }

    public static void showAllStudentsWithNegativeGrade(){
        ArrayIterator ai = new ArrayIterator(sl.getStudents());
        Predicate p = new NegativeGradePredicate();
        FilteringArrayIterator fai = new FilteringArrayIterator(ai, p);
        System.out.println("Lista studentów, którzy nie zaliczyli kursu:");
        sl.showStudents(fai);
    }

    public static void showAllStudentsWithPositiveGradeAboveAverage(){
        ArrayIterator ai = new ArrayIterator(sl.getStudents());
        Predicate p = new PositiveGradePredicate();
        FilteringArrayIterator fai = new FilteringArrayIterator(ai, p);
        double average = sl.averageGrade(fai);
        Predicate p2 = new Predicate(){
            @Override
            public boolean accept(Object o) {
                return ((Student) o).getGrade() > average;
            }
        };
        FilteringArrayIterator fai2 = new FilteringArrayIterator(ai, p2);
        System.out.println("Lista studentów, którzy zaliczyli z oceną powyżej średniej:");
        sl.showStudents(fai2);
    }

    public static void showAllStudentsWithPositiveGradeBelowAverage(){
        ArrayIterator ai = new ArrayIterator(sl.getStudents());
        Predicate p = new PositiveGradePredicate();
        FilteringArrayIterator fai = new FilteringArrayIterator(ai, p);
        double average = sl.averageGrade(fai);
        Predicate p2 = new Predicate(){
            @Override
            public boolean accept(Object o) {
                return ((Student) o).getGrade() < average;
            }
        };
        FilteringArrayIterator fai2 = new FilteringArrayIterator(fai, p2);
        System.out.println("Lista studentów, którzy zaliczyli z oceną poniżej średniej:");
        sl.showStudents(fai2);
    }

    public static void addStudent(Student s){
        ArrayIterator ai = new ArrayIterator(sl.getStudents());
        Predicate p = new Predicate(){
            @Override
            public boolean accept(Object o) {
                return ((Student)o).getIndexNo() < s.getIndexNo();
            }
        };
        FilteringArrayIterator fai = new FilteringArrayIterator(ai, p);
        sl.add(fai, s);
    }

    public static void removeStudent(int indexNo){
        ArrayIterator ai = new ArrayIterator(sl.getStudents());
        Predicate p = new Predicate(){
            @Override
            public boolean accept(Object o) {
                return ((Student)o).getIndexNo() != indexNo;
            }
        };
        FilteringArrayIterator fai = new FilteringArrayIterator(ai, p);
        sl.remove(fai);
    }

    public static void bubbleSortStudents(){
        ArrayIterator ai = new ArrayIterator(sl.getStudents());
        sl.bubbleSort(ai);
    }

}
