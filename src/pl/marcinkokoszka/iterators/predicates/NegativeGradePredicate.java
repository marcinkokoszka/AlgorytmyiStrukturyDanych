package pl.marcinkokoszka.iterators.predicates;

import pl.marcinkokoszka.Student;

/**
 * Created by kokoseq on 08.03.2017.
 */
public class NegativeGradePredicate implements Predicate {
    public boolean accept(Object o){
        return !(((Student) o).getGrade() >= 3.0);
    }
}
