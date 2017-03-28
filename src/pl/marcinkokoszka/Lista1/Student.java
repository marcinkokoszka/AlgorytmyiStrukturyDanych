package pl.marcinkokoszka.Lista1;

/**
 * Created by kokoseq on 08.03.2017.
 */
public class Student implements Comparable {
    private String name;
    private String surname;
    private int indexNo;
    private double grade;

    public Student(int indexNo){
        this.indexNo = indexNo;
    }

    public Student(String name, String surname, int indexNo, double grade) {
        this.name = name;
        this.surname = surname;
        this.indexNo = indexNo;
        this.grade = grade;
    }

    public Student(Student s){
        this.name = s.getName();
        this.surname = s.getSurname();
        this.indexNo = s.getIndexNo();
        this.grade = s.getGrade();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(int indexNo) {
        this.indexNo = indexNo;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String toString(){
        return surname + ", " + name + ", " + indexNo + ", " + grade;
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student) o;
        return this.indexNo > s.indexNo? 1:this.indexNo < s.indexNo? -1:0;
    }
}
