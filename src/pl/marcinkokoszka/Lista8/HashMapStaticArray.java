package pl.marcinkokoszka.Lista8;

/**
 * Created by kokoseq on 20.05.2017.
 */

import java.util.Arrays;

public class HashMapStaticArray<K, V> {
    private int size;
    private Pair<K, V>[] array;
    private int capacity = 4;

    static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashMapStaticArray() {
        array = new Pair[capacity];
    }

    public void put(K newKey, V data) {
        if (newKey == null)
            return;

        int hash = hash(newKey);

        Pair<K, V> newPair = new Pair<>(newKey, data);

        boolean inserted = false;
        if (array[hash] == null) {
            array[hash] = newPair;
            inserted = true;
        } else {
            for (int i = hash; i < array.length; i++) {
                if (array[i] == null) {
                    array[i] = newPair;
                    inserted = true;
                    break;
                }
            }
            if (!inserted) {
                for (int i = 0; i < hash; i++) {
                    if (array[i] == null) {
                        array[i] = newPair;
                        inserted = true;
                        break;
                    }
                }
            }
            if (!inserted) {
                checkCapacity();
                array[size++] = newPair;
            }
        }
        if (inserted)
            size++;
    }

    private void checkCapacity() {
        if (size == array.length) {
            int newSize = array.length * 2;
            array = Arrays.copyOf(array, newSize);
        }
    }

    public V get(K key) {
        int hash = hash(key);
        if (array[hash].key.equals(key)) {
            return array[hash].value;
        } else {
            for (int i = hash; i < array.length; i++) {
                if (array[i].key.equals(key)) {
                    return array[i].value;
                }
            }
            for (int i = 0; i < hash; i++) {
                if (array[i].key.equals(key)) {
                    return array[i].value;
                }
            }
            return null;
        }
    }

    public boolean remove(K deleteKey) {

        int hash = hash(deleteKey);

        if (array[hash].key.equals(deleteKey)) {
            array[hash] = null;
            size--;
            return true;
        } else {
            for (int i = hash; i < array.length; i++) {
                if (array[i].key.equals(deleteKey)) {
                    array[i] = null;
                    size--;
                    return true;
                }
            }
            for (int i = 0; i < hash; i++) {
                if (array[i].key.equals(deleteKey)) {
                    array[i] = null;
                    size--;
                    return true;
                }
            }
            return false;
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null)
                s.append(array[i].key).append(":").append(array[i].value).append("\n");
        }
        return s.toString();
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

}