Palindrome Index:
  import java.util.*;

class Result {

    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {

                // Try removing the left character
                if (isPalindrome(s, left + 1, right)) {
                    return left;
                }

                // Otherwise, try removing the right character
                if (isPalindrome(s, left, right - 1)) {
                    return right;
                }

                return -1;
            }

            left++;
            right--;
        }

        // Already a palindrome
        return -1;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        while (q-- > 0) {
            String s = sc.next();
            System.out.println(Result.palindromeIndex(s));
        }

        sc.close();
    }
}
OUTPUT:
Compiler Message
Success
Input (stdin)
3
aaab
baa
aaa
Expected Output
3
0
-1

