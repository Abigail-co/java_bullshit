import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Student> students = new LinkedList<Student>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continuing = true;
        while(continuing) {
            System.out.print(
            """
                
                1. Add a Student
                2. Print out the student list
                3. Add a grade
                4. Delete a Student
                5. Sort by last name
                6. Sort by name
                7. Sort by average
                8. Exit
                >\s""");
            int choice = scanner.nextInt();


            switch(choice) {
                case 1:
                    add_student(scanner);
                    break;
                case 2:
                    print_students();
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 3:
                    add_grade(scanner);
                    break;
                case 4:
                    delete_student(scanner);
                    break;
                case 5:
                    sort_last_name();
                    break;
                case 6:
                    sort_name();
                    break;
                case 7:
                    sort_average();
                    break;
                case 8:
                    continuing = false;
            }

        }
    }
    public static void add_student(Scanner scanner) {
        System.out.print("Name of the student:\n> ");
        String name = scanner.next();
        System.out.print("Last name of the student:\n> ");
        String lastname = scanner.next();
        students.add(new Student(name, lastname));
    }
    public static void print_students() {
        int i = 1;
        for(Student student : students) {
            System.out.println(i + ". " + student.name + " " + student.last_name);
            for(Integer grade : student.grades) {
                System.out.print(grade + " ");
            }
            System.out.print("\n");
            i++;
        }
        System.out.print("\nClick enter to continue...");
    }
    public static void add_grade(Scanner scanner) {
        print_students_with_indexes();
        System.out.print("Which student?\n> ");
        int choice = scanner.nextInt();
        Student student = students.get(choice - 1);
        System.out.print("What grade?\n> ");
        int grade = scanner.nextInt();
        student.grades.add(grade);
    }
    public static void delete_student(Scanner scanner) {
        print_students_with_indexes();
        System.out.print("Which student?\n> ");
        int choice = scanner.nextInt();
        students.remove(choice - 1);
    }
    public static void sort_last_name() {
        students.sort(Comparator.comparing(hs -> hs.last_name));
    }
    public static void sort_name() {
        students.sort(Comparator.comparing(hs -> hs.last_name));
    }
    public static void sort_average() {
        students.sort(Comparator.comparing(Student::average));
    }


    public static void print_students_with_indexes() {
        int i = 1;
        for(Student student : students) {
            System.out.println(i + ". " + student.name + " " + student.last_name);
            i++;
        }
    }
}