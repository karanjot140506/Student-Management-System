import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String rollNumber;
    String name;
    String course;
    String email;

    Student(String rollNumber, String name, String course, String email) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.course = course;
        this.email = email;
    }

    void display() {
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Name: "+ name);
        System.out.println("Course: "+ course);
        System.out.println("Email: "+ email);
    }
}

public class StudentManagement {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter Roll Number: ");
        String roll = scanner.nextLine();

        for (Student s : students) {
            if (s.rollNumber.equals(roll)) {
                System.out.println("Student with this roll number already exists.");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        students.add(new Student(roll, name, course, email));
        System.out.println("Student added successfully.");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            s.display();
        }
    }

    static void updateStudent() {
        System.out.print("Enter Roll Number to update: ");
        String roll = scanner.nextLine();

        for (Student s : students) {
            if (s.rollNumber.equals(roll)) {
                System.out.print("Enter new Name (leave blank to keep current): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) s.name = name;

                System.out.print("Enter new Course (leave blank to keep current): ");
                String course = scanner.nextLine();
                if (!course.isEmpty()) s.course = course;

                System.out.print("Enter new Email (leave blank to keep current): ");
                String email = scanner.nextLine();
                if (!email.isEmpty()) s.email = email;

                System.out.println("Student record updated.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter Roll Number to delete: ");
        String roll = scanner.nextLine();

        for (Student s : students) {
            if (s.rollNumber.equals(roll)) {
                students.remove(s);
                System.out.println("Student deleted.");
                return;
            }
        }

        System.out.println("Student not found.");
    }
}
