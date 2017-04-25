package pl.marcinkokoszka.Lista5;

/**
 * Created by kokoseq on 25.04.2017.
 */
public interface ListSorterCounter {

    int getAssignments();

    int getCompares();

    public void setAssignments(int assignments);

    public void setCompares(int compares);

    default void clear(){
        setAssignments(0);
        setCompares(0);
    }
}
