import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentQueue queue = new StudentQueue();
        // Initialize scanner and random number generator
        Scanner scanner = new Scanner(System.in);
        // Random number generator for generating random names
        Random random = new Random();
        String command;

        System.out.println("Welcome to the Student Queue Management System");
        System.out.println("Available commands: addstudent, addstaff, remove, receipt, exit");

        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("addstudent")) {
                String name = "Student" + (random.nextInt(9000) + 1000);// Generate a random student name
                queue.addPerson(name, Person.Type.STUDENT);
                System.out.println(name + " has been added to the queue.");
            } else if (command.equalsIgnoreCase("addstaff")) {
                String name = "Staff" + (random.nextInt(9000) + 1000);// Generate a random staff name
                queue.addPerson(name, Person.Type.STAFF);
                System.out.println(name + " has been added to the queue.");
            } else if (command.equalsIgnoreCase("remove")) {
                Person removed = queue.removePerson();
                if (removed != null) {
                    System.out.println(removed.name + " (" + removed.type + ") has been removed from the queue.");
                } else {
                    System.out.println("The queue is empty.");
                }
            } else if (command.equalsIgnoreCase("receipt")) {
                int students = queue.countStudents();
                int staff = queue.countStaff();
                System.out.println("🧾 ----------- Queue Receipt ----------- 🧾");
                System.out.println("👩‍🎓 Students in queue: " + students);//Add Emoji for students
                System.out.println("👨‍🏫 Staff in queue: " + staff);//Add Emoji for staffs
                System.out.println("🧾 ------------------------------------- 🧾");
            } else if (command.equalsIgnoreCase("exit")) {// Exit the application
                System.out.println("Thank you for using the Student Queue Management System!");
                System.out.println("Goodbye!");
                break;
            } else {// If the command is not recognized
                System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
    }
}