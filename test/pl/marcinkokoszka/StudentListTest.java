package pl.marcinkokoszka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kokoseq on 08.03.2017.
 */
public class StudentListTest {
    StudentList sl;

    @Before
    public void setUp() {
        sl = new StudentList();
    }

    @After
    public void tearDown(){
        sl = null;
    }

    @Test
    public void setGradeByIndexNo_whenNoStudents(){
        }

    @Test
    public void setGradeByIndexNo_whenNoIndex(){
    }

    @Test
    public void setGradeByIndexNo_whenIndexExists(){
    }

    @Test
    public void averagePositiveGrade_whenNoStudents(){
    }

    @Test
    public void averagePositiveGrade_whenOneStudentWithPositiveGrade(){
    }

    @Test
    public void averagePositiveGrade_whenOneStudentWithNegativeGradeAndTwoStudentsWithPositiveGrades(){
    }

    @Test
    public void averagePositiveGrade_whenMoreDifferentStudents(){
    }


}
