import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

class Student {
    private String name;
    private String id;
    private List<Double> grades;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return grades.size() > 0 ? sum / grades.size() : 0;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void printGrades() {
        System.out.println("Grades for " + name + ": " + grades);
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println("Student: " + student.getName() + " | Average Grade: " + student.calculateAverage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        System.out.println("Welcome to the Student Management System!");

        // Adding example students
        Student student1 = new Student("Alice", "S001");
        student1.addGrade(90);
        student1.addGrade(85);

        Student student2 = new Student("Bob", "S002");
        student2.addGrade(88);
        student2.addGrade(92);

        sms.addStudent(student1);
        sms.addStudent(student2);

        sms.displayAllStudents();

        // Find student by ID
        System.out.print("\nEnter Student ID to view details: ");
        String id = scanner.nextLine();
        Student student = sms.findStudentById(id);

        if (student != null) {
            student.printGrades();
        } else {
            System.out.println("Student not found!");
        }
    }
}
