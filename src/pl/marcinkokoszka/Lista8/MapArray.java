package pl.marcinkokoszka.Lista8;

/**
 * Created by kokoseq on 20.05.2017.
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

    public class MapArray<K, V> {
        private int size;
        private int DEFAULT_CAPACITY = 16;
        @SuppressWarnings("unchecked")
        private MapEntry<K, V>[] values = new MapEntry[DEFAULT_CAPACITY];

        static class MapEntry<K, V> {
            private final K key;
            private V value;

            public MapEntry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }


        public V get(K key) {
            for (int i = 0; i < size; i++) {
                if (values[i] != null) {
                    if (values[i].key.equals(key)) {
                        return values[i].value;
                    }
                }
            }
            return null;
        }

        public void put(K key, V value) {
            boolean insert = true;
            for (int i = 0; i < size; i++) {
                if (values[i].key.equals(key)) {
                    values[i].value = value;
                    insert = false;
                }
            }
            if (insert) {
                ensureCapacity();
                values[size++] = new MapEntry<>(key, value);
            }
        }

        private void ensureCapacity() {
            if (size == values.length) {
                int newSize = values.length * 2;
                values = Arrays.copyOf(values, newSize);
            }
        }

        public int size() {
            return size;
        }

        public void remove(K key) {
            for (int i = 0; i < size; i++) {
                if (values[i].key.equals(key)) {
                    values[i] = null;
                    size--;
                    condenseArray(i);
                }
            }
        }

        private void condenseArray(int start) {
            System.arraycopy(values, start + 1, values, start, size - start);
        }

        public Set<K> keySet() {
            Set<K> set = new HashSet<K>();
            for (int i = 0; i < size; i++) {
                set.add(values[i].key);
            }
            return set;
        }

        public String toString(){
            StringBuilder s = new StringBuilder();
            for(int i = 0; i < size; i++){
                if(values[i] != null)
                s.append(values[i].key).append(":").append(values[i].value).append("\n");
            }
            return s.toString();
        }
    }