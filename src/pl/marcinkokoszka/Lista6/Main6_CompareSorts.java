package pl.marcinkokoszka.Lista6;

import pl.marcinkokoszka.Lista1.Student;
import pl.marcinkokoszka.Lista4.ArrayList;
import pl.marcinkokoszka.Lista4.List;
import pl.marcinkokoszka.Lista5.*;
import pl.marcinkokoszka.Lista5.Comparators.NaturalComparator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by kokoseq on 25.04.2017.
 */
public class Main6_CompareSorts {

    private static int[] assignments;
    private static int[] compares;

    private static List sorterList;

    public static void main(String[] args) {

        zadanie1();

    }

    private static void zadanie1() {
        sorterList = new ArrayList(6);

        sorterList.add(new MergeSort(NaturalComparator.INSTANCE));
        sorterList.add(new QuickSort(NaturalComparator.INSTANCE));

        Integer[] increments1;
        Integer[] increments2;

        ArrayList value = new ArrayList();
        int x = 1;
        int i;
        int listSize = getAlmostSortedListAscending().size();
        do {
            i = listSize / (int) Math.pow(2, x);
            value.add(i);
            x++;
        } while (i > (listSize/3));

        increments1 = new Integer[value.size()];
        for (int n = 0; n < value.size(); n++){
            increments1[n] = (int) value.get(n);
        }

        value = new ArrayList();
        x = 1;
        do {
            i = (int) Math.pow(2, x)-1;
            value.add(i);
            x++;
        } while (i < (listSize/3));
        increments2 = new Integer[value.size()];
        for (int n = 0; n < value.size(); n++){
            increments2[n] = (int) value.get(n);
        }
        Arrays.sort(increments2, Collections.reverseOrder());

        sorterList.add(new ShellSort(NaturalComparator.INSTANCE, increments1));
        sorterList.add(new ShellSort(NaturalComparator.INSTANCE, increments2));

        sorterList.add(new CountingSort((NaturalComparator.INSTANCE)));

        sorterList.add(new HeapOrderedListPriorityQueue(NaturalComparator.INSTANCE));

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

    private static void analyseSort(List list){
        for(int i = 0; i < sorterList.size(); i++){
            ArrayList temp = new ArrayList((ArrayList)list);
            if (sorterList.get(i) instanceof ListSorter) {
                ListSorter ls = (ListSorter) sorterList.get(i);
                ls.sort(temp);
                compares[i] = ls.getCompares();
                assignments[i] = ls.getAssignments();
                ls.clear();
            } else {
                HeapOrderedListPriorityQueue ls = (HeapOrderedListPriorityQueue) sorterList.get(i);
                for (int j = 0; j < temp.size(); j++){
                    ls.enqueue(temp.get(j));
                }
                compares[i] = ls.getCompares();
                assignments[i] = ls.getAssignments();
                ls.clear();
            }
        }

        for(int i = 0; i < compares.length; i++) {
            System.out.println("=== Ilość porównań w algorytmie " + i + " : " + compares[i] + " ==");
        }

        System.out.println();

        for(int i = 0; i < assignments.length; i++) {
            System.out.println("=== Ilość przepisań w algorytmie " + i + " : " + assignments[i] + " ==");
        }
    }

    private static List getAlmostSortedListAscending(){
        try (FileReader fr = new FileReader("ALMOST_SORTED_ASCENDING.csv");
             BufferedReader br = new BufferedReader(fr)){

            ArrayList list = new ArrayList();
            String line;
            String[] dataFromLine;

            line = br.readLine();
            dataFromLine = line.split(",");
            for (String s:dataFromLine){
                list.add(Integer.valueOf(s));
            }
            return list;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List getAlmostSortedListDescending() {
        try (FileReader fr = new FileReader("ALMOST_SORTED_DESCENDING.csv");
             BufferedReader br = new BufferedReader(fr)){

            ArrayList list = new ArrayList();
            String line;
            String[] dataFromLine;

            while ((line = br.readLine()) != null) {
                dataFromLine = line.split(",");
                for (String s:dataFromLine){
                    list.add(Integer.valueOf(s));
                }
            }
            return list;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List getRandomList() {
        try (FileReader fr = new FileReader("FULLY_RANDOM_ASCENDING.csv");
             BufferedReader br = new BufferedReader(fr)){

            ArrayList list = new ArrayList();
            String line;
            String[] dataFromLine;

            while ((line = br.readLine()) != null) {
                dataFromLine = line.split(",");
                for (String s:dataFromLine){
                    if (s != null && !s.isEmpty())
                        list.add(Integer.valueOf(s));
                }
            }
            return list;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
