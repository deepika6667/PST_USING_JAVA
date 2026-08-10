JAVA SORT:
import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class Checker implements Comparator<Student> {

    public int compare(Student s1, Student s2) {

        // CGPA - decreasing order
        if (s1.getCgpa() < s2.getCgpa()) {
            return 1;
        } else if (s1.getCgpa() > s2.getCgpa()) {
            return -1;
        }

        // Name - alphabetical order
        int result = s1.getName().compareTo(s2.getName());

        if (result != 0) {
            return result;
        }

        // ID - increasing order
        return s1.getId() - s2.getId();
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Student> students = new ArrayList<Student>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();

            students.add(new Student(id, name, cgpa));
        }

        Collections.sort(students, new Checker());

        for (Student student : students) {
            System.out.println(student.getName());
        }

        sc.close();
    }
}
OUTPUT:
Input (stdin)
5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76
Your Output (stdout)
Ashis
Fahim
Samara
Samiha
Rumpa
Expected Output
Ashis
Fahim
Samara
Samiha
Rumpa
