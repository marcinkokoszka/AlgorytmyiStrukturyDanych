package pl.marcinkokoszka.Lista7;

/**
 * Created by kokoseq on 15.05.2017.
 */
class RedBlackNode<T extends Comparable<T>> {

    public static final int BLACK = 0;
    public static final int RED = 1;

    public T key;

    RedBlackNode<T> parent;
    RedBlackNode<T> left;
    RedBlackNode<T> right;

    public int numLeft = 0;
    public int numRight = 0;

    public int color;

    RedBlackNode(){
        color = BLACK;
        numLeft = 0;
        numRight = 0;
        parent = null;
        left = null;
        right = null;
    }

    RedBlackNode(T key){
        this();
        this.key = key;
    }

    void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + key + ":" + getColor());
        if (left.key != null && right.key != null)
            left.print(prefix + (isTail ? "    " : "│   "), false);
        else if (left.key != null)
            left.print(prefix + (isTail ? "    " : "│   "), true);
        if (right.key != null)
            right.print(prefix + (isTail ? "    " : "│   "), true);
    }

    private String getColor(){
        if(color == 1) return "Czerwony";
        else return "Czarny";
    }
}