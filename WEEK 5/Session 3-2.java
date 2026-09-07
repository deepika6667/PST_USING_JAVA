alternating-characters:
import java.io.*;
import java.util.*;

public class Solution {

    public static int alternatingCharacters(String s) {
        int deletions = 0;
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                deletions++;
            }
        }
        
        return deletions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int q = scanner.nextInt();
            while (q-- > 0) {
                String s = scanner.next();
                System.out.println(alternatingCharacters(s));
            }
        }
        scanner.close();
    }
}
OUTPUT:
Input (stdin)
5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB
Your Output (stdout)
3
4
0
0
4
Expected Output
3
4
0
0
4
