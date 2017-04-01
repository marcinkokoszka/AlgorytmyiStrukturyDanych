package pl.marcinkokoszka.Lista3;

/**
 * Created by kokoseq on 30.03.2017.
 */
public class Customer implements Comparable{
    private int customerNo;
    private int t;

    public Customer(int t, int customerNo){
        this.customerNo = customerNo;
        this.t = t;
    }

    public int getT(){
        return t;
    }

    public String toString(){
        return "Klient nr: " + customerNo;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
