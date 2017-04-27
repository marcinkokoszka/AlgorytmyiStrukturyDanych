package pl.marcinkokoszka.Lista5.Comparators;

/**
 * Created by kokoseq on 27.04.2017.
 */
public class NaturalComparator implements Comparator {

    public static final NaturalComparator INSTANCE = new NaturalComparator();

    private NaturalComparator(){}

    @Override
    public int compare(Object o1, Object o2) {
        return ((Comparable) o1).compareTo(o2);
    }
}
