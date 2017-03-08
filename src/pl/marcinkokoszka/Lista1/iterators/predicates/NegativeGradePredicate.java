package pl.marcinkokoszka.Lista1.iterators.predicates;

import pl.marcinkokoszka.Lista1.Student;

/**
 * Created by kokoseq on 08.03.2017.
 */
public class NegativeGradePredicate implements Predicate {
    public boolean accept(Object o){
        return !(((Student) o).getGrade() >= 3.0);
    }
}
