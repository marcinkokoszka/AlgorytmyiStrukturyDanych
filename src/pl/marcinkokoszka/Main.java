package pl.marcinkokoszka;

import pl.marcinkokoszka.iterators.ArrayIterator;
import pl.marcinkokoszka.iterators.FilteringArrayIterator;
import pl.marcinkokoszka.iterators.predicates.NegativeGradePredicate;
import pl.marcinkokoszka.iterators.predicates.PositiveGradePredicate;
import pl.marcinkokoszka.iterators.predicates.Predicate;

public class Main {
    public static StudentList sl;

    public static void main(String[] args) {

        sl = new StudentList();

        showAllStudents();

        System.out.println();

        showAllStudentsWithNegativeGrade();

        System.out.println();

        averagePositiveGrade();
    }

    public static void showAllStudents() {
        ArrayIterator ai = new ArrayIterator(sl.getStudents());
        System.out.println("Lista wszystkich studentów:");
        sl.showStudents(ai);
    }

    public static void setGradeByIndexNo() {

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
