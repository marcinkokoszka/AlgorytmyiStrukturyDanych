package pl.marcinkokoszka.Lista3;

/**
 * Created by kokoseq on 30.03.2017.
 */
public class Clerk {
    private Object currentlyServiced;

    public Clerk(){
        currentlyServiced = null;
    }

    public void startService(Customer c) {
        System.out.println("Start obsługi klienta " + c.toString());
        for (int i = 0; i < c.getT(); i++) {
            System.out.println();
        }
        System.out.println("Start obsługi klienta " + c.toString());
    }

    public boolean isAvailable(){
        return currentlyServiced == null;
    }
}
