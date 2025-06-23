
/**
 * 
 *
 * @author Duc Tran Tri
 * @version (17/06/2025)
 */
public class Student
{
    // instance variables - replace the example below with your own
    private String student;
    private Student next;
    
    /**
     * Constructor for objects of class Node
     */
    public Student()
    {
        // initialise instance variables
        this.student = student;
    }
    
    /*-setters-*/
    public void setStuden(String student)
    {
        this.student = student;
    }

    public void setNextStudent(Student next)
    {
        this.next = next;
    }

    /*getters*/
    public String getStudent()
    {
        return this.student;
    }

    public Student getNextStudent()
    {
        return this.next;
    }
}
