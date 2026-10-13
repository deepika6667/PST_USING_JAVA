java hashset:
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

//Write your code here

Set<String> set = new HashSet<String>();
for (int i = 0; i < t; i++) {
    set.add(pair_left[i] + " " + pair_right[i]);
    System.out.println(set.size());
}

    }
}
OUTPUT:
Congratulations!

You have passed the sample test cases. Click the submit button to run your code against all the test cases.


Sample Test case 0
Input (stdin)
5
john tom
john mary
john tom
mary anna
mary anna
Your Output (stdout)
1
2
2
