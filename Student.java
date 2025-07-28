
/**
 * 
 * Canteen Queues
 * Your student council needs you!
 * The WHS student council has fielded many complaints about staff members jumping the queue in the canteen.
 * They are gathering concrete information about how often this happens, and how many students turn up and what rates during interval and lunch time.
 * While they gather this information,
 * they have asked help from computer science students to build a simulator that will allow them to demonstrate how this behaviour by staff impacts students
 * 
 * The task
 * 
 * The council has determined that the simulator must:
 * 
 * 1: Have a configuration file that lists minute by minute the number of:
 *	Students arriving, staff arriving, customers served.
 * The student council is working with maths department students to generate this information.  
 * It is not yet ready, so you will have to come up with a starting set of values.
 * 2: After each run, the simulator must show mean student and staff wait times,  
 * both in the situation where staff members are served immediately the current person is served, 
 * and when the staff member has to wait in line.
 * In addition the simulator could:
 * 3: Be able to run a configurable number of simulations on the same configuration file but introducing a small degree of randomness to exact arrivals and serving numbers; 
 * and present summary statistics.
 * 4: The simulator could have options for trying various “What if” scenarios (changed student/staff arrival rate by a %; changed time to serve%).
 * 5: The simulator could also be able to accommodate a configurable maximum queue length, after which nobody joins the queue as it is too long. 
 * Statistics about how many people “go hungry” because of the queue length in both the staff queue jumping, and non-queue jumping should also be kept and made available.
 * 
 * You may
 * You may have a purely text-based interface or use a GUI with menus for selecting options.
 * No visual representation of a queue is required, although you may optionally provide one.
 * If 2m distancing is in place in the queue, this will restrict the number of people in the queue, 
 * you might have an option for indicating how this could affect things.
 * 
 * @author Duc Tran Tri
 * @version (17/06/2025)
 */

//Student class

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
    public void setStudent(String student)
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
