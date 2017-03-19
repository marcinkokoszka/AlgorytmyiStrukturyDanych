package pl.marcinkokoszka.Lista2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pl.marcinkokoszka.Lista1.Student;

/**
 * Created by kokoseq on 18.03.2017.
 */
public class LinkedListTest {
    private LinkedList<Student> lls;

    @Before
    public void setUp() {
        lls = new LinkedList<>();
    }

    @After
    public void tearDown(){
        lls = null;
    }

    @Test
    public void listSize_equalToZero_WhenCleared(){
        lls.clear();
        assertEquals(0, lls.size());
    }

    @Test
    public void listSize_equalToOne_WhenOneStudentAdded(){
        lls.clear();
        lls.add(new Student("Marcin", "Kokoszka", 169472, 4.5));
        assertEquals(1, lls.size());
    }

    @Test
    public void listSize_equalToZero_WhenOneStudentAddedAndDeleted(){
        lls.clear();
        Student mk = new Student("Marcin", "Kokoszka", 169472, 4.5);
        lls.add(mk);
        lls.delete(mk);
        assertEquals(0, lls.size());
    }

    @Test
    public void listSize_equalToZero_WhenOneStudentAddedAndDeletedByIndexNo(){
        lls.clear();
        Student mk = new Student("Marcin", "Kokoszka", 169472, 4.5);
        lls.add(mk);
        lls.delete(0);
        assertEquals(0, lls.size());
    }

    @Test
    public void indexOfStudent_equalsToNegativeOne_WhenDeleted(){
        lls.clear();
        Student mk = new Student("Marcin", "Kokoszka", 169472, 4.5);
        lls.add(mk);
        lls.delete(mk);
        //System.out.println(lls.get(0));
        assertEquals(-1, lls.indexOf(mk));
    }

    @Test
    public void indexOfStudent_equalsToNegativeOne_WhenDeletedByIndexNo(){
        lls.clear();
        Student mk = new Student("Marcin", "Kokoszka", 169472, 4.5);
        lls.add(mk);
        lls.delete(0);
        //System.out.println(lls.get(0));
        assertEquals(-1, lls.indexOf(mk));
    }

    @Test
    public void get_returnsInsertedStudents_WhenThreeStudentsAdded(){
        lls.clear();
        Student s1 = new Student("Marcin", "Kokoszka", 169472, 4.5);
        Student s2 = new Student("Jan", "Kowalski", 123456, 4.0);
        Student s3 = new Student("Stanisław", "Nowak", 234567, 3.5);
        lls.add(s1);
        lls.add(s2);
        lls.add(s3);
        assertEquals(s1, lls.get(0));
        assertEquals(s2, lls.get(1));
        assertEquals(s3, lls.get(2));
    }

    @Test
    public void set_changesStudent_WhenThreeStudentsAdded(){
        lls.clear();
        Student s1 = new Student("Marcin", "Kokoszka", 169472, 4.5);
        Student s2 = new Student("Jan", "Kowalski", 123456, 4.0);
        Student s3 = new Student("Stanisław", "Nowak", 234567, 3.5);
        lls.add(s1);
        lls.add(s2);
        lls.add(s3);
        lls.set(1, s3);
        assertEquals(s3, lls.get(1));
    }

    @Test
    public void contains_returnsTrue_WhenStudentInList(){
        lls.clear();
        Student s1 = new Student("Marcin", "Kokoszka", 169472, 4.5);
        Student s2 = new Student("Jan", "Kowalski", 123456, 4.0);
        Student s3 = new Student("Stanisław", "Nowak", 234567, 3.5);
        lls.add(s1);
        lls.add(s2);
        lls.add(s3);
        assertTrue(lls.contains(s2));
    }

    @Test
    public void contains_returnsTrue_WhenExactlyOneStudentInList(){
        lls.clear();
        Student s1 = new Student("Marcin", "Kokoszka", 169472, 4.5);
        lls.add(s1);
        assertTrue(lls.contains(s1));
    }

    @Test
    public void contains_returnsFalse_WhenListEmpty(){
        lls.clear();
        Student s1 = new Student("Marcin", "Kokoszka", 169472, 4.5);
        assertFalse(lls.contains(s1));
    }

    @Test
    public void contains_returnsFalse_WhenStudentNotInList(){
        lls.clear();
        Student s1 = new Student("Marcin", "Kokoszka", 169472, 4.5);
        Student s2 = new Student("Jan", "Kowalski", 123456, 4.0);
        Student s3 = new Student("Stanisław", "Nowak", 234567, 3.5);
        lls.add(s1);
        lls.add(s2);
        assertFalse(lls.contains(s3));
    }

    @Test
    public void contains_returnsFalse_WhenTwoStudentsDeletedByIndex0(){
        lls.clear();
        Student s1 = new Student("Marcin", "Kokoszka", 169472, 4.5);
        Student s2 = new Student("Jan", "Kowalski", 123456, 4.0);
        Student s3 = new Student("Stanisław", "Nowak", 234567, 3.5);
        lls.add(s1);
        lls.add(s2);
        lls.add(s3);
        lls.delete(0);
        lls.delete(0);
        System.out.println(lls.get(0));
        assertFalse(lls.contains(s1));
        assertFalse(lls.contains(s2));
    }

    @Test
    public void contains_returnsFalse_WhenTwoStudentsDeletedByIndex0And1(){
        lls.clear();
        Student s1 = new Student("Marcin", "Kokoszka", 169472, 4.5);
        Student s2 = new Student("Jan", "Kowalski", 123456, 4.0);
        Student s3 = new Student("Stanisław", "Nowak", 234567, 3.5);
        lls.add(s1);
        lls.add(s2);
        lls.add(s3);
        lls.delete(0);
        lls.delete(1);
        System.out.println(lls.get(0));
        assertFalse(lls.contains(s1));
        assertFalse(lls.contains(s3));
    }

    @Test
    public void isEmpty_returnsTrue_WhenListEmpty(){
        lls.clear();
        assertTrue(lls.isEmpty());
    }

    @Test
    public void isEmpty_returnsTrue_WhenStudentAddedAndDeleted(){
        lls.clear();
        Student mk = new Student("Marcin", "Kokoszka", 169472, 4.5);
        lls.add(mk);
        lls.delete(mk);
        assertTrue(lls.isEmpty());
    }

    @Test
    public void isEmpty_returnsFalse_WhenExactlyOneStudentInList(){
        lls.clear();
        Student mk = new Student("Marcin", "Kokoszka", 169472, 4.5);
        lls.add(mk);
        assertFalse(lls.isEmpty());
    }
}
