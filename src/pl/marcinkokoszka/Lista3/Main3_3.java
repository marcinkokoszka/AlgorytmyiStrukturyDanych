package pl.marcinkokoszka.Lista3;

import java.util.ArrayList;

/**
 * Created by kokoseq on 30.03.2017.
 */
public class Main3_3 {
    static int currentCustomerNo;
    public static void main(String[] args) {

        ArrayList<Clerk> clerks = new ArrayList<>();
        clerks.add(new Clerk("A"));
        clerks.add(new Clerk("B"));
        clerks.add(new Clerk("C"));

        int initialNoOfCustomers = 100;
        currentCustomerNo = initialNoOfCustomers + 1;
        FIFOQueueDirectImplementation<Customer> sc = generateCustomers(initialNoOfCustomers);

        service(clerks, sc);
    }

    public static void service(ArrayList<Clerk> clerks, FIFOQueueDirectImplementation<Customer> sc){

        for (int i = 0; i < 240; i++){
            System.out.println("Minuta: " + (i + 1));
            for (Clerk c:clerks){
                try {
                    if (c.isAvailable()) {
                        c.setCurrentlyServiced(sc.dequeue());
                        System.out.println(c);
                    }
                } catch (EmptyQueueException e){
                    System.out.println("Pusta kolejka klientów.");
                }
                c.decreaseMinutesToEndService();
            }
            possiblyAddRandomCustomer(sc);
        }
    }

    private static void possiblyAddRandomCustomer(FIFOQueueDirectImplementation<Customer> sc) {
        if (Math.random() > 0.8) {
            Customer c = new Customer((int)(Math.random() * (10 - 1) + 1), currentCustomerNo++);
            sc.enqueue(c);
            System.out.println("Do kolejki doszedł :" + c);
        }
    }

    private static FIFOQueueDirectImplementation<Customer> generateCustomers(int qty){
        FIFOQueueDirectImplementation<Customer> sc = new FIFOQueueDirectImplementation<>();
        for (int i = 0; i < qty; i++){
            sc.enqueue(new Customer((int)(Math.random() * (10 - 1) + 1), i + 1));
        }
        return sc;
    }

}
