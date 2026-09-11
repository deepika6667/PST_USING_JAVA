Mars Exploration:
import java.io.*;
import java.util.*;

class Result {

    public static int marsExploration(String s) {
        int count = 0;

        String pattern = "SOS";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != pattern.charAt(i % 3)) {
                count++;
            }
        }

        return count;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int result = Result.marsExploration(s);

        System.out.println(result);

        sc.close();
    }
}
OUTPUT:
Compiler Message
Success
Input (stdin)
SOSSPSSQSSOR
Expected Output
3
