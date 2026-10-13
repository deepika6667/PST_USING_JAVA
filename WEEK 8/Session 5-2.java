Java Exception Handling (Try-catch):
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
try {
    int x = sc.nextInt();
    int y = sc.nextInt();
    System.out.println(x / y);
} catch (InputMismatchException e) {
    System.out.println("java.util.InputMismatchException");
} catch (ArithmeticException e) {
    System.out.println("java.lang.ArithmeticException: / by zero");
}
    }
}
OUTPUT:
Congratulations!

You have passed the sample test cases. Click the submit button to run your code against all the test cases.


Sample Test case 0

Sample Test case 1

Sample Test case 2

Sample Test case 3

Sample Test case 4
Input (stdin)
10
3
Your Output (stdout)
3
Expected Output
3
