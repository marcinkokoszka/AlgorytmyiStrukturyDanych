package pl.marcinkokoszka.Lista7;

/**
 * Created by kokoseq on 15.05.2017.
 */
public class Main7 {
    public static void main(String[] args) {

        Tree<Integer> t1 = new Tree<>();

        t1.addKey(5);
        t1.addKey(2);
        t1.addKey(8);
        t1.addKey(1);
        t1.addKey(6);
        t1.addKey(3);
        t1.addKey(7);
        t1.addKey(0);

        RedBlackTree<Integer> t2 = new RedBlackTree<>();

        t2.insert(5);
        t2.print();
        System.out.println();
        t2.insert(2);
        t2.print();
        System.out.println();
        t2.insert(8);
        t2.print();
        System.out.println();
        t2.insert(1);
        t2.print();
        System.out.println();
        t2.insert(6);
        t2.print();
        System.out.println();
        t2.insert(3);
        t2.print();
        System.out.println();
        t2.insert(7);
        t2.print();
        System.out.println();
        t2.insert(0);
        t2.print();
        System.out.println();

        TreePrinter.printNode(t1.getRoot());
        System.out.println();
        t1.getRoot().print();
        System.out.println();

    }


}
