JAVA LAMBDA EXPRESSIONS:
import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    // Java 7 implementation using Anonymous Inner Classes
    public static PerformOperation isOdd() {
        return new PerformOperation() {
            @Override
            public boolean check(int n) {
                return n % 2 != 0;
            }
        };
    }

    public static PerformOperation isPrime() {
        return new PerformOperation() {
            @Override
            public boolean check(int n) {
                if (n < 2) return false;
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) return false;
                }
                return true;
            }
        };
    }

    public static PerformOperation isPalindrome() {
        return new PerformOperation() {
            @Override
            public boolean check(int n) {
                String original = Integer.toString(n);
                String reversed = new StringBuilder(original).reverse().toString();
                return original.equals(reversed);
            }
        };
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = MyMath.isOdd();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = MyMath.isPrime();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = MyMath.isPalindrome();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(ans);
        }
    }
}
OUTPUT:

Input (stdin)
5
1 4
2 5
3 898
1 3
2 12
Your Output (stdout)
EVEN
PRIME
PALINDROME
ODD
COMPOSITE
Expected Output
EVEN
PRIME
PALINDROME
ODD
COMPOSITE
