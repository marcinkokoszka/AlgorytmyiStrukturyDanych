package pl.marcinkokoszka.Lista7;

/**
 * Created by kokoseq on 20.05.2017.
 */
public class Node<T> {

    T data;
    Node<T> left = null;
    Node<T> right = null;
    Node<T> parent = null;
    int nodes = 0;
    int height = 0;
    int leaves = 0;
    int overload = 0;

    Node(T data) {
        this.data = data;
    }

    public void print() {
        print("", true);
    }

    private void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + data);
        if (left != null && right != null)
            left.print(prefix + (isTail ? "    " : "│   "), false);
        else if (left != null)
            left.print(prefix + (isTail ? "    " : "│   "), true);
        if (right != null)
            right.print(prefix + (isTail ? "    " : "│   "), true);
    }
}
