package pl.marcinkokoszka.Lista8;

/**
 * Created by kokoseq on 20.05.2017.
 */
class HashMapArrayOfLists<K, V> {

    private Pair<K, V>[] array;
    private int capacity = 4;

    static class Pair<K, V> {
        K key;
        V value;
        Pair<K, V> next;

        public Pair(K key, V value, Pair<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public HashMapArrayOfLists() {
        array = new Pair[capacity];
    }

    public void put(K newKey, V data) {
        if (newKey == null)
            return;

        int hash = hash(newKey);

        Pair<K, V> newPair = new Pair<>(newKey, data, null);

        if (array[hash] == null) {
            array[hash] = newPair;
        } else {
            Pair<K, V> previous = null;
            Pair<K, V> current = array[hash];

            while (current != null) {
                if (current.key.equals(newKey)) {
                    if (previous == null) {
                        newPair.next = current.next;
                        array[hash] = newPair;
                        return;
                    } else {
                        newPair.next = current.next;
                        previous.next = newPair;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newPair;
        }
    }

    public V get(K key) {
        int hash = hash(key);
        if (array[hash] == null) {
            return null;
        } else {
            Pair<K, V> temp = array[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next;
            }
            return null;
        }
    }

    public boolean remove(K deleteKey) {

        int hash = hash(deleteKey);

        if (array[hash] == null) {
            return false;
        } else {
            Pair<K, V> previous = null;
            Pair<K, V> current = array[hash];

            while (current != null) {
                if (current.key.equals(deleteKey)) {
                    if (previous == null) {
                        array[hash] = array[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                Pair<K, V> pair = array[i];
                while (pair != null) {
                    s.append(pair.key).append(":").append(pair.value).append("\n");
                    pair = pair.next;
                }
            }
        }
        return s.toString();
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

}