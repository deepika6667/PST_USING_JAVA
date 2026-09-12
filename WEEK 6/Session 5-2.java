Circular Palindromes:
import java.util.*;

public class Solution {

    static int n;
    static int[] odd, even;
    static int[][] sparseOdd, sparseEven;
    static int[] log;

    // Range maximum query for odd palindromes
    static int queryOdd(int left, int right) {
        if (left > right) {
            return 0;
        }

        int k = log[right - left + 1];

        return Math.max(
            sparseOdd[k][left],
            sparseOdd[k][right - (1 << k) + 1]
        );
    }

    // Range maximum query for even palindromes
    static int queryEven(int left, int right) {
        if (left > right) {
            return 0;
        }

        int k = log[right - left + 1];

        return Math.max(
            sparseEven[k][left],
            sparseEven[k][right - (1 << k) + 1]
        );
    }

    // Manacher's Algorithm
    static void manacher(String s) {

        int m = s.length();

        odd = new int[m];
        even = new int[m];

        // Odd length palindromes
        int l = 0;
        int r = -1;

        for (int i = 0; i < m; i++) {

            int k = (i > r)
                    ? 1
                    : Math.min(odd[l + r - i], r - i + 1);

            while (i - k >= 0 &&
                   i + k < m &&
                   s.charAt(i - k) == s.charAt(i + k)) {
                k++;
            }

            odd[i] = k;

            k--;

            if (i + k > r) {
                l = i - k;
                r = i + k;
            }
        }

        // Even length palindromes
        l = 0;
        r = -1;

        for (int i = 0; i < m; i++) {

            int k = (i > r)
                    ? 0
                    : Math.min(
                        even[l + r - i + 1],
                        r - i + 1
                    );

            while (i - k - 1 >= 0 &&
                   i + k < m &&
                   s.charAt(i - k - 1) == s.charAt(i + k)) {
                k++;
            }

            even[i] = k;

            k--;

            if (i + k > r) {
                l = i - k - 1;
                r = i + k;
            }
        }
    }

    // Build Sparse Tables
    static void buildSparse(int m) {

        log = new int[m + 1];

        for (int i = 2; i <= m; i++) {
            log[i] = log[i / 2] + 1;
        }

        int levels = log[m] + 1;

        sparseOdd = new int[levels][m];
        sparseEven = new int[levels][m];

        for (int i = 0; i < m; i++) {
            sparseOdd[0][i] = odd[i];
            sparseEven[0][i] = even[i];
        }

        for (int k = 1; k < levels; k++) {

            int half = 1 << (k - 1);
            int size = 1 << k;

            for (int i = 0; i + size <= m; i++) {

                sparseOdd[k][i] = Math.max(
                    sparseOdd[k - 1][i],
                    sparseOdd[k - 1][i + half]
                );

                sparseEven[k][i] = Math.max(
                    sparseEven[k - 1][i],
                    sparseEven[k - 1][i + half]
                );
            }
        }
    }

    /*
     * Check if an odd palindrome with radius >= radius
     * exists completely inside this rotation.
     *
     * Odd palindrome length = 2 * radius - 1
     */
    static boolean hasOdd(int start, int radius) {

        int end = start + n - 1;

        int leftCenter = start + radius - 1;
        int rightCenter = end - radius + 1;

        if (leftCenter > rightCenter) {
            return false;
        }

        return queryOdd(leftCenter, rightCenter) >= radius;
    }

    /*
     * Check if an even palindrome with radius >= radius
     * exists completely inside this rotation.
     *
     * Even palindrome length = 2 * radius
     */
    static boolean hasEven(int start, int radius) {

        int end = start + n - 1;

        int leftCenter = start + radius;
        int rightCenter = end - radius + 1;

        if (leftCenter > rightCenter) {
            return false;
        }

        return queryEven(leftCenter, rightCenter) >= radius;
    }

    static int solveRotation(int start) {

        // Find maximum odd radius
        int low = 1;
        int high = (n + 1) / 2;
        int bestOdd = 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (hasOdd(start, mid)) {
                bestOdd = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int oddLength = 2 * bestOdd - 1;

        // Find maximum even radius
        low = 1;
        high = n / 2;
        int bestEven = 0;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (hasEven(start, mid)) {
                bestEven = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int evenLength = 2 * bestEven;

        return Math.max(oddLength, evenLength);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        String s = sc.next();

        // All rotations are contained in s + s
        String doubled = s + s;

        // Calculate palindrome radii once
        manacher(doubled);

        // Build RMQ structures
        buildSparse(doubled.length());

        StringBuilder output = new StringBuilder();

        // Process all n rotations
        for (int start = 0; start < n; start++) {

            int answer = solveRotation(start);

            output.append(answer).append('\n');
        }

        System.out.print(output);

        sc.close();
    }
}
OUTPUT:
Compiler Message
Success
Input (stdin)
13
aaaaabbbbaaaa
Expected Output
12
12
10
8
8
9
11
13
11
9
8
8
10
