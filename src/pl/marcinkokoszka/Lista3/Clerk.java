package pl.marcinkokoszka.Lista3;

/**
 * Created by kokoseq on 30.03.2017.
 */
public class Clerk {
    private String name;
    private Customer currentlyServiced;
    private int minutesToEndService;

    public Clerk(String name) {
        this.name = name;
        currentlyServiced = null;
    }

    public String getName() {
        return name;
    }

    public void setCurrentlyServiced(Customer o){
        currentlyServiced = o;
        minutesToEndService = o.getT();
    }

    public boolean isAvailable() {
        return currentlyServiced == null;
    }

    public void decreaseMinutesToEndService() {
        if (minutesToEndService > 0) minutesToEndService--;
        if (minutesToEndService <= 0) {
            minutesToEndService = 0;
            currentlyServiced = null;
        }
    }

    public String toString() {
        return name + " obsluguje: " + currentlyServiced;
    }
}
