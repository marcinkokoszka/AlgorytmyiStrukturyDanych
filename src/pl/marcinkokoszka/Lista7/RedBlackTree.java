package pl.marcinkokoszka.Lista7;

/**
 * Created by kokoseq on 15.05.2017.
 */

public class RedBlackTree<T extends Comparable<T>> {

    private RedBlackNode<T> nil = new RedBlackNode<T>();
    private RedBlackNode<T> root = nil;

    public RedBlackTree() {
        root.left = nil;
        root.right = nil;
        root.parent = nil;
    }

    public void print(){
        root.print("", true);
    }

    public void insert(T key) {
        insert(new RedBlackNode<T>(key));
    }

    private void insert(RedBlackNode<T> z) {

        RedBlackNode<T> y = nil;
        RedBlackNode<T> x = root;

        // Szukaj miejsca, w które wstawić
        while (!isNil(x)){
            y = x;

            // jeśli z.key jest < aktualnego klucza, idź w lewo
            if (z.key.compareTo(x.key) < 0){

                // Aktualizuj x.numLeft, jako, że z jest < x
                x.numLeft++;
                x = x.left;
            }

            // z.key >= x.key, idź w prawo
            else{

                // Aktualizuj x.numRight, jako, że z jest >= x
                x.numRight++;
                x = x.right;
            }
        }

        z.parent = y;

        // W zależności od y.key, ustaw z jako lewe albo prawe dziecko y
        if (isNil(y))
            root = z;
        else if (z.key.compareTo(y.key) < 0)
            y.left = z;
        else
            y.right = z;

        z.left = nil;
        z.right = nil;
        z.color = RedBlackNode.RED;

        insertFixup(z);
    }


    // wierzchołek, który został włożony do drzewa mógł zaburzyć właściwości drzewa
    // Naprawia właściwości drzewa zaburzone przy insert()
    private void insertFixup(RedBlackNode<T> z){

        RedBlackNode<T> y = nil;
        // Dopóki właściwości drzewa są zaburzone
        while (z.parent.color == RedBlackNode.RED){

            // Jeśli z.parent jest lewym dzieckiem swojego rodzica
            if (z.parent == z.parent.parent.left){

                // y staje się kuzynem z
                y = z.parent.parent.right;

                // Przypadek 1: jeśli z jest czerwone, zmień kolor
                if (y.color == RedBlackNode.RED){
                    z.parent.color = RedBlackNode.BLACK;
                    y.color = RedBlackNode.BLACK;
                    z.parent.parent.color = RedBlackNode.RED;
                    z = z.parent.parent;
                }
                // Przypadek 2: jeśli y jest czarne i z jest prawym dzieckiem
                else if (z == z.parent.right){

                    // obróć w lewo względem rodzica z
                    z = z.parent;
                    leftRotate(z);
                }

                // Przypadek 3: y jest czarne i z jest lewym dzieckiem
                else{
                    // zmień kolor i obróć względem dziadka z
                    z.parent.color = RedBlackNode.BLACK;
                    z.parent.parent.color = RedBlackNode.RED;
                    rightRotate(z.parent.parent);
                }
            }

            // Jeśli rodzic z jest prawym dzieckiem swego rodzica
            else{
                // y staje się kuzynem z
                y = z.parent.parent.left;

                // Przypadek 1: jeśli y jest czerwone, zmień kolor
                if (y.color == RedBlackNode.RED){
                    z.parent.color = RedBlackNode.BLACK;
                    y.color = RedBlackNode.BLACK;
                    z.parent.parent.color = RedBlackNode.RED;
                    z = z.parent.parent;
                }

                // Przypadek 2: jeśli y jest czarne i z jest lewym dzieckiem
                else if (z == z.parent.left){
                    // obróć w prawo względem rodzica z
                    z = z.parent;
                    rightRotate(z);
                }
                // Przypadek 3: jeśli y jest czarne i z jest prawym dzieckiem
                else{
                    // zmień kolor i obróć względem dziadka z
                    z.parent.color = RedBlackNode.BLACK;
                    z.parent.parent.color = RedBlackNode.RED;
                    leftRotate(z.parent.parent);
                }
            }
        }
        // Zawsze zmień kolor korzenia na czarny
        root.color = RedBlackNode.BLACK;
    }

    private void leftRotate(RedBlackNode<T> x){

        // aktualizacja numLeft i numRight
        leftRotateFixup(x);

        RedBlackNode<T> y;
        y = x.right;
        x.right = y.left;

        // czy istnieje y.left i zamiana referencji
        if (!isNil(y.left))
            y.left.parent = x;
        y.parent = x.parent;

        // x.parent jest nil
        if (isNil(x.parent))
            root = y;

        // x jest lewym dzieckiem swojego rodzica
        else if (x.parent.left == x)
            x.parent.left = y;

        //x jest prawym dzieckiem swojego rodzica
        else
            x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    // Aktualizuje numLeft i numRight afektowany przez leftRotate.
    private void leftRotateFixup(RedBlackNode x){

        // Przypadek 1: tylko x, x.right i x.right.right są nil.
        if (isNil(x.left) && isNil(x.right.left)){
            x.numLeft = 0;
            x.numRight = 0;
            x.right.numLeft = 1;
        }

        // Przypadek 2: x.right.left istnieje w dodatku do przypadku 1
        else if (isNil(x.left) && !isNil(x.right.left)){
            x.numLeft = 0;
            x.numRight = 1 + x.right.left.numLeft +
                    x.right.left.numRight;
            x.right.numLeft = 2 + x.right.left.numLeft +
                    x.right.left.numRight;
        }

        // Przypadek 3: x.left także istnieje w dodatku do przypadku 1
        else if (!isNil(x.left) && isNil(x.right.left)){
            x.numRight = 0;
            x.right.numLeft = 2 + x.left.numLeft + x.left.numRight;

        }

        // Przypadek 4: x.left i x.right.left istnieją w dodatku do przypadku 1
        else{
            x.numRight = 1 + x.right.left.numLeft +
                    x.right.left.numRight;
            x.right.numLeft = 3 + x.left.numLeft + x.left.numRight +
                    x.right.left.numLeft + x.right.left.numRight;
        }
    }

    private void rightRotate(RedBlackNode<T> y){

        // aktualizacja numLeft i numRight
        rightRotateFixup(y);

        RedBlackNode<T> x = y.left;
        y.left = x.right;

        // Czy istnieje x.right
        if (!isNil(x.right))
            x.right.parent = y;
        x.parent = y.parent;

        // y.parent jest nil
        if (isNil(y.parent))
            root = x;

        // y jest prawym dzieckiem swojego rodzica
        else if (y.parent.right == y)
            y.parent.right = x;

        // y jest lewym dzieckiem swojego rodzica
        else
            y.parent.left = x;
        x.right = y;

        y.parent = x;

    }

    // Aktualizuje numLeft i numRight afektowany przez rightRotate.
    private void rightRotateFixup(RedBlackNode y){

        // Przypadek 1: tylko y, y.left i y.left.left są nil.
        if (isNil(y.right) && isNil(y.left.right)){
            y.numRight = 0;
            y.numLeft = 0;
            y.left.numRight = 1;
        }

        // Przypadek 2: y.left.right istnieje w dodatku do przypadku 1
        else if (isNil(y.right) && !isNil(y.left.right)){
            y.numRight = 0;
            y.numLeft = 1 + y.left.right.numRight +
                    y.left.right.numLeft;
            y.left.numRight = 2 + y.left.right.numRight +
                    y.left.right.numLeft;
        }

        // Przypadek 3: y.right istnieje w dodatku do przypadku 1
        else if (!isNil(y.right) && isNil(y.left.right)){
            y.numLeft = 0;
            y.left.numRight = 2 + y.right.numRight +y.right.numLeft;

        }

        // Przypadek 4: y.right i y.left.right istnieją w dodatku do przypadku 1
        else{
            y.numLeft = 1 + y.left.right.numRight +
                    y.left.right.numLeft;
            y.left.numRight = 3 + y.right.numRight +
                    y.right.numLeft +
                    y.left.right.numRight + y.left.right.numLeft;
        }

    }

    private boolean isNil(RedBlackNode node){
        return node == nil;
    }
}