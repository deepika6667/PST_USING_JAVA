String Similarity:
import java.io.*;

public class Solution {

    static long stringSimilarity(String s) {
        int n = s.length();
        int[] z = new int[n];

        int left = 0;
        int right = 0;

        long sum = n; // Similarity of S with itself

        for (int i = 1; i < n; i++) {

            if (i <= right) {
                z[i] = Math.min(right - i + 1, z[i - left]);
            }

            while (i + z[i] < n &&
                   s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }

            sum += z[i];
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();

            System.out.println(stringSimilarity(s));
        }
    }
}
OUTPUT:
Input (stdin)
2
ababaa
aa
Your Output (stdout)
11
3
Expected Output
11
3
