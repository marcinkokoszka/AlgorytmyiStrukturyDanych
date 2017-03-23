package pl.marcinkokoszka.Lista2;

/**
 * Created by kokoseq on 23.03.2017.
 */
import java.util.Scanner;

public class Main3 {

    private CircularLinkedList cl;
    private int n;
    private int k;

    public static void main(String args[]){
        Main3 main3=new Main3();
        main3.setInts();
        main3.buildCircularLinkedList();
        main3.startTheGame();
    }

    public void setInts(){
        System.out.print("Podaj liczbę osób (N):");
        Scanner in=new Scanner(System.in);
        n =in.nextInt();
        System.out.print("Podaj, co która osoba ginie (K):");
        k =in.nextInt();
    }

    public void buildCircularLinkedList(){
        cl=new CircularLinkedList();
        for(int i = 1; i<= n; i++)
            cl.add(i);
    }

    public void startTheGame(){
        cl.game(k);
    }


}