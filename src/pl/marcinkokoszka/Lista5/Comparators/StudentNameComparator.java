package pl.marcinkokoszka.Lista5.Comparators;

import pl.marcinkokoszka.Lista1.Student;

/**
 * Created by kokoseq on 27.04.2017.
 */
public class StudentNameComparator implements Comparator {

    public static final StudentNameComparator INSTANCE = new StudentNameComparator();

    private StudentNameComparator(){}

    @Override
    public int compare(Object o1, Object o2) {
        return ((Student) o1).getSurname().compareTo(((Student)o2).getSurname());
    }
}
