CONSTRAINT-DRIVEN SOLUTION DESIGN(STUDENT ELIGIBILITY SYSTEM):
  import java.util.Scanner;

class Student {
    String name;
    int age;
    double attendance;
    double cgpa;
    boolean subjectsPassed;
    boolean disciplinaryIssue;

    Student(String name, int age, double attendance,
            double cgpa, boolean subjectsPassed,
            boolean disciplinaryIssue) {

        this.name = name;
        this.age = age;
        this.attendance = attendance;
        this.cgpa = cgpa;
        this.subjectsPassed = subjectsPassed;
        this.disciplinaryIssue = disciplinaryIssue;
    }
}

public class StudentEligibilitySystem {

    static boolean checkEligibility(Student s) {

        if (s.age < 18) {
            System.out.println("Not Eligible: Age is below 18.");
            return false;
        }

        if (s.attendance < 75) {
            System.out.println("Not Eligible: Attendance is below 75%.");
            return false;
        }

        if (s.cgpa < 6.0) {
            System.out.println("Not Eligible: CGPA is below 6.0.");
            return false;
        }

        if (!s.subjectsPassed) {
            System.out.println("Not Eligible: All subjects are not passed.");
            return false;
        }

        if (s.disciplinaryIssue) {
            System.out.println("Not Eligible: Disciplinary issue exists.");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Student Eligibility System =====");

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.print("Enter attendance percentage: ");
        double attendance = sc.nextDouble();

        System.out.print("Enter CGPA: ");
        double cgpa = sc.nextDouble();

        System.out.print("Has the student passed all subjects? (true/false): ");
        boolean subjectsPassed = sc.nextBoolean();

        System.out.print("Does the student have a disciplinary issue? (true/false): ");
        boolean disciplinaryIssue = sc.nextBoolean();

        Student student = new Student(
                name,
                age,
                attendance,
                cgpa,
                subjectsPassed,
                disciplinaryIssue
        );

        System.out.println("\n===== Eligibility Result =====");
        System.out.println("Student Name: " + student.name);

        if (checkEligibility(student)) {
            System.out.println("Status: ELIGIBLE");
        } else {
            System.out.println("Status: NOT ELIGIBLE");
        }

        sc.close();
    }
}

OUTPUT:
C:\Users\Deepu\Downloads>java ConstraintDrivenSolution
Enter number of students: 3

Enter student details:

Student 1 name: deepu
Marks (0-100): 85
Attendance (0-100): 80

Student 2 name: manjulatha
Marks (0-100): 100
Attendance (0-100): 1090
Invalid input! Values must be between 0 and 100.

Student 2 name: manjulatha
Marks (0-100): 100
Attendance (0-100): 100

Student 3 name: bhavitha
Marks (0-100): 100
Attendance (0-100): 100

===== ELIGIBILITY RESULTS =====
deepu -> Eligible
manjulatha -> Eligible
bhavitha -> Eligible

Total Students: 3
Eligible Students: 3
Not Eligible Students: 0
  
