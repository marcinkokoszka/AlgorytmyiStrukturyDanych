package pl.marcinkokoszka.Lista8;

/**
 * Created by kokoseq on 20.05.2017.
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MapStaticArray<K, V> {
    private int size;
    private Entry<K,V>[] table;
    private int capacity= 4;

    static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    public MapStaticArray(){
        table = new Entry[capacity];
    }

    public void put(K newKey, V data) {
        if (newKey == null)
            return;

        int hash = hash(newKey);

        Entry<K, V> newEntry = new Entry<>(newKey, data);

        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            boolean inserted = false;
            for(int i = hash; i < table.length; i++){
                if(table[i] == null){
                    table[i] = newEntry;
                    inserted = true;
                    break;
                }
            }
            if (!inserted){
                for(int i = 0; i < hash; i++){
                    if(table[i] == null){
                        table[i] = newEntry;
                        inserted = true;
                        break;
                    }
                }
            }
            if(!inserted){
                ensureCapacity();
                table[size++] = newEntry;
            }
        }
    }

    private void ensureCapacity() {
        if (size == table.length) {
            int newSize = table.length * 2;
            table = Arrays.copyOf(table, newSize);
        }
    }

    public V get(K key){
        int hash = hash(key);
        if(table[hash].key.equals(key)){
            return table[hash].value;
        }else{
            for(int i = hash; i < table.length; i++){
                if(table[i].key.equals(key)){
                    return table[i].value;
                }
            }
            for(int i = 0; i < hash; i++){
                if(table[i].key.equals(key)){
                    return table[i].value;
                }
            }
            return null;
        }
    }

    public boolean remove(K deleteKey) {

        int hash = hash(deleteKey);

        if (table[hash].key.equals(deleteKey)) {
            table[hash] = null;
            return true;
        } else {
            for (int i = hash; i < table.length; i++) {
                if (table[i].key.equals(deleteKey)) {
                    table[i] = null;
                    return true;
                }
            }
            for (int i = 0; i < hash; i++) {
                if (table[i].key.equals(deleteKey)) {
                    table[i] = null;
                    return true;
                }
            }
            return false;
        }
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < size; i++){
            if(table[i] != null)
                s.append(table[i].key).append(":").append(table[i].value).append("\n");
        }
        return s.toString();
    }

    private int hash(K key){
        return Math.abs(key.hashCode()) % capacity;
    }

}