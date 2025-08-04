// Main.java
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        StudentQueue queue = new StudentQueue();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Student Queue Management System");
        System.out.println("Available commands: add, remove, exit");

        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("add")) {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                queue.addStudent(name);
                System.out.println(name + " has been added to the queue.");
            } else if (command.equalsIgnoreCase("remove")) {
                String removedStudent = queue.removeStudent();
                if (removedStudent != null) {
                    System.out.println(removedStudent + " has been removed from the queue.");
                } else {
                    System.out.println("The queue is empty.");
                }
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the application.");
                break;
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
    }
}