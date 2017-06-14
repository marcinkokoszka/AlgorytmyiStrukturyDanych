package pl.marcinkokoszka.Lista8;

/**
 * Created by kokoseq on 20.05.2017.
 */
public class Main8_1 {

    public static void main(String[] args) {
        MapArrayDirectAccess map1 = new MapArrayDirectAccess();

        System.out.println("Utworzenie mapy");
        System.out.println("Dodanie kilku pozycji");
        map1.put(1, "Marcin");
        map1.put(2, "Anna");
        map1.put(3, "Zbigniew");
        map1.put(8, "Laura");
        map1.put(15, "Marzenna");
        map1.put(13, "Hubert");
        map1.put(0, "Michał");
        map1.put(12, "Albert");

        System.out.println("Zawartość mapy:");
        System.out.println(map1);

        System.out.println("Usunięcie klucza '13'");
        map1.remove(13);
        System.out.println("Zawartość mapy:");
        System.out.println(map1);

        HashMapArrayOfLists<Integer, String> map2 = new HashMapArrayOfLists<>();

        System.out.println("Utworzenie hash mapy z metodą łańcuchową - tablicą list");
        System.out.println("Dodanie kilku pozycji");
        map2.put(1, "Marcin");
        map2.put(2, "Anna");
        map2.put(3, "Zbigniew");
        map2.put(8, "Laura");
        map2.put(19, "Marzenna");
        map2.put(21, "Hubert");
        map2.put(189, "Michał");
        map2.put(34565, "Albert");

        System.out.println("Zawartość mapy:");
        System.out.println(map2);

        System.out.println("Usunięcie klucza '189'");
        map2.remove(189);
        System.out.println("Zawartość mapy:");
        System.out.println(map2);


        HashMapStaticArray<Integer, String> map3 = new HashMapStaticArray<>();

        System.out.println("Utworzenie hash mapy z tablicą statyczną");
        System.out.println("Dodanie kilku pozycji");
        map3.put(1, "Marcin");
        map3.put(2, "Anna");
        map3.put(3, "Zbigniew");
        map3.put(8, "Laura");
        map3.put(19, "Marzenna");
        map3.put(21, "Hubert");
        map3.put(189, "Michał");
        map3.put(34565, "Albert");

        System.out.println("Zawartość mapy:");
        System.out.println(map3);

        System.out.println("Usunięcie klucza '189'");
        map3.remove(189);
        System.out.println("Zawartość mapy:");
        System.out.println(map3);
    }
}
