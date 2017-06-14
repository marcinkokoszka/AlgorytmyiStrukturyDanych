package pl.marcinkokoszka.Lista8;

/**
 * Created by kokoseq on 20.05.2017.
 */
//Zadanie 1 - Adresowanie bezpośrednie
public class MapArrayDirectAccess {
    private int size;
    private int MAX_CAPACITY = 16;
    @SuppressWarnings("unchecked")
    private Object[] array = new Object[MAX_CAPACITY];

    public Object get(int key) {
        return array[key];
    }

    public void put(int key, Object value) {
        array[key] = value;
        size++;
    }

    public int size() {
        return size;
    }

    public void remove(int key) {
        if (array[key] != null) {
            array[key] = null;
            size--;
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if (array[i] != null)
                s.append(i).append(":").append(array[i]).append("\n");
        }
        return s.toString();
    }
}