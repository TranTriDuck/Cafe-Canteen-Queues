// StudentQueue.java

//Import necessary classes

public class StudentQueue {
    private Student front;
    private Student rear;
    private int size;
    

    

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
}