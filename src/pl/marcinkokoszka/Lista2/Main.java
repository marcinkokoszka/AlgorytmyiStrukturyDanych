package pl.marcinkokoszka.Lista2;

import pl.marcinkokoszka.Lista1.Student;
import pl.marcinkokoszka.Lista1.iterators.Iterator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kokoseq on 14.03.2017.
 */
public class Main {

    public static void main(String[] args) {

        LinkedList<Student> lls = readStudentsFromTxt();

        Iterator llsIterator = lls.iterator();

        while(!llsIterator.isDone()){
            System.out.println(llsIterator.current());
        }


    }

    private static LinkedList<Student> readStudentsFromTxt(){
        try (FileReader fr = new FileReader("Studenci.txt");
             BufferedReader br = new BufferedReader(fr)){

            LinkedList<Student> students = new LinkedList<>();
            String line;
            String[] dataFromLine;

            while ((line = br.readLine()) != null) {
                dataFromLine = line.split(";");
                students.add((new Student(dataFromLine[0], dataFromLine[1], Integer.parseInt(dataFromLine[2]), Double.parseDouble(dataFromLine[3]))));
            }

            return students;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
