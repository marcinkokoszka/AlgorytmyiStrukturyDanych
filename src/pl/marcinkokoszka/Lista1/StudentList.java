package pl.marcinkokoszka.Lista1;

import pl.marcinkokoszka.Lista1.iterators.Iterator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kokoseq on 08.03.2017.
 */
public class StudentList {
    private Student[] students;

    public StudentList(){
        readStudentsFromTxt();
    }

    public Student[] getStudents(){
        return students;
    }

    public void showStudents(Iterator i){
        for(i.first(); !i.isDone(); i.next()){
            System.out.println(i.current());
        }
    }

    public void averageGrade(Iterator i){
        double averageGrade = 0;
        int counter = 0;

        for(i.first(); !i.isDone(); i.next()){
            averageGrade += ((Student) i.current()).getGrade();
            counter++;
        }

        averageGrade /= counter;
        System.out.println(averageGrade);
    }

    public void setGrade(Iterator i, double grade){
        for(i.first(); !i.isDone(); i.next()){
            ((Student) i.current()).setGrade(grade);
        }
    }

    private void readStudentsFromTxt(){
        try (FileReader fr = new FileReader("Studenci.txt");
             BufferedReader br = new BufferedReader(fr)){

            students = new Student[0];
            String line;
            String[] dataFromLine;

            while ((line = br.readLine()) != null) {
                dataFromLine = line.split(";");
                add(new Student(dataFromLine[0], dataFromLine[1], Integer.parseInt(dataFromLine[2]), Double.parseDouble(dataFromLine[3])));
            }

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    private void add(Student e) {
        Student[] temp = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            temp[i] = students[i];
        }
        temp[students.length] = e;
        students = temp;
    }
}
