// StudentQueue.java

//Import necessary classes
import java.util.LinkedList;
import java.util.Queue;

public class StudentQueue {
    private Queue<Person> queue = new LinkedList<>();
    private Student front;
    private Student rear;
    private int size;
    
    
    public void addPerson(String name, Person.Type type) {
        queue.add(new Person(name, type));
    }

    public StudentQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(String studentName) {
        Student newStudent = new Student(studentName);
        newStudent.setNextStudent(null);

        if (isEmpty()) {
            front = newStudent;
        } else {
            rear.setNextStudent(newStudent);
        }
        rear = newStudent;
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        String studentName = front.getName();
        front = front.getNextStudent();
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return studentName;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
    
    public String removeStudent() {
        return dequeue();
    }

    public void addStudent(String name) {
        enqueue(name);
    }

     public Person removePerson() {
        return queue.poll();
    }

        public int countStudents() {
        return (int) queue.stream().filter(p -> p.type == Person.Type.STUDENT).count();
    }

    public int countStaff() {
        return (int) queue.stream().filter(p -> p.type == Person.Type.STAFF).count();
    }
}