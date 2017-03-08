package pl.marcinkokoszka.Lista1;

import pl.marcinkokoszka.Lista1.iterators.ArrayIterator;
import pl.marcinkokoszka.Lista1.iterators.FilteringArrayIterator;
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

        System.out.println("Ustawienie oceny 3.0 dla studenta o albumie 807834");
        setGradeByIndexNo(807834, 3.0);
        
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
        sl.averageGrade(fai);
    }

    public static void showAllStudentsWithNegativeGrade(){
        ArrayIterator ai = new ArrayIterator(sl.getStudents());
        Predicate p = new NegativeGradePredicate();
        FilteringArrayIterator fai = new FilteringArrayIterator(ai, p);
        System.out.println("Lista studentów, którzy nie zaliczyli kursu:");
        sl.showStudents(fai);
    }


}
