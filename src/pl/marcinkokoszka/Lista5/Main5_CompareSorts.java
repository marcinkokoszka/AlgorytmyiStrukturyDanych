package pl.marcinkokoszka.Lista5;

import pl.marcinkokoszka.Lista1.Student;
import pl.marcinkokoszka.Lista4.List;
import pl.marcinkokoszka.Lista4.ArrayList;
import pl.marcinkokoszka.Lista5.Comparators.NaturalComparator;
import pl.marcinkokoszka.Lista5.Comparators.StudentNameComparator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kokoseq on 25.04.2017.
 */
public class Main5_CompareSorts {

    private static int[] assignments;
    private static int[] compares;

    private static List sorterList;

    public static void main(String[] args) {

        //zadanie1();

        zadanie2();
    }

    private static void zadanie1(){
        sorterList = new ArrayList(4);

        sorterList.add(new BubbleSort(NaturalComparator.INSTANCE));
        sorterList.add(new InsertSort(NaturalComparator.INSTANCE));
        sorterList.add(new SelectSort(NaturalComparator.INSTANCE));
        sorterList.add(new ShakerSort(NaturalComparator.INSTANCE)); //ZADANIE 3

        assignments = new int[sorterList.size()];
        compares = new int[sorterList.size()];

        System.out.println("=== Analiza algorytmów sortowania dla listy prawie posortowanej rosnąco ===");
        analyseSort(getAlmostSortedListAscending());
        System.out.println("\n");

        System.out.println("=== Analiza algorytmów sortowania dla listy prawie posortowanej malejąco ===");
        analyseSort(getAlmostSortedListDescending());
        System.out.println("\n");

        System.out.println("=== Analiza algorytmów sortowania dla listy nieposortowanej ===");
        analyseSort(getRandomList());
    }

    private static void zadanie2(){
        sorterList = new ArrayList(4);

        sorterList.add(new BubbleSort(NaturalComparator.INSTANCE));
        sorterList.add(new InsertSort(NaturalComparator.INSTANCE));
        sorterList.add(new SelectSort(NaturalComparator.INSTANCE));
        sorterList.add(new ShakerSort(NaturalComparator.INSTANCE)); //ZADANIE 3

        assignments = new int[sorterList.size()];
        compares = new int[sorterList.size()];

        System.out.println("=== Analiza algorytmów sortowania dla listy studentów wg indeksu ===");
        analyseSort(getStudentList());
        System.out.println("\n");

        sorterList = new ArrayList(4);

        sorterList.add(new BubbleSort(StudentNameComparator.INSTANCE));
        sorterList.add(new InsertSort(StudentNameComparator.INSTANCE));
        sorterList.add(new SelectSort(StudentNameComparator.INSTANCE));
        sorterList.add(new ShakerSort(StudentNameComparator.INSTANCE)); //ZADANIE 3

        assignments = new int[sorterList.size()];
        compares = new int[sorterList.size()];

        System.out.println("=== Analiza algorytmów sortowania dla listy studentów wg nazwiska ===");
        analyseSort(getStudentList());
        System.out.println("\n");

    }

    private static void analyseSort(List list){
        for(int i = 0; i < sorterList.size(); i++){
            ArrayList temp = new ArrayList((ArrayList)list);
            ListSorter ls = (ListSorter) sorterList.get(i);
            ls.sort(temp);
            compares[i] = ls.getCompares();
            assignments[i] = ls.getAssignments();
            ls.clear();
        }

        for(int i = 0; i < compares.length; i++) {
            System.out.println("=== Ilość porównań w algorytmie " + i + " : " + compares[i] + " ==");
        }

        System.out.println();

        for(int i = 0; i < assignments.length; i++) {
            System.out.println("=== Ilość przepisań w algorytmie " + i + " : " + assignments[i] + " ==");
        }
    }

    public static List getAlmostSortedListAscending() {

        List integers = new ArrayList();
        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(6);
        integers.add(5);
        integers.add(7);
        integers.add(8);
        integers.add(9);

        return integers;
    }

    public static List getAlmostSortedListDescending() {

        List integers = new ArrayList();
        integers.add(9);
        integers.add(8);
        integers.add(7);
        integers.add(5);
        integers.add(6);
        integers.add(4);
        integers.add(3);
        integers.add(2);
        integers.add(1);
        integers.add(0);

        return integers;
    }

    public static List getRandomList() {

        List integers = new ArrayList();
        integers.add(5);
        integers.add(2);
        integers.add(7);
        integers.add(9);
        integers.add(1);
        integers.add(0);
        integers.add(6);
        integers.add(3);
        integers.add(8);
        integers.add(4);

        return integers;
    }

    public static List getStudentList() {
            try (FileReader fr = new FileReader("Studenci.txt");
                 BufferedReader br = new BufferedReader(fr)){

                List students = new ArrayList();
                String line;
                String[] dataFromLine;

                int i = 0;
                while ((line = br.readLine()) != null && i < 10) {
                    dataFromLine = line.split(";");
                    students.add((new Student(dataFromLine[0], dataFromLine[1], Integer.parseInt(dataFromLine[2]), Double.parseDouble(dataFromLine[3]))));
                    i++;
                }

                return students;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
