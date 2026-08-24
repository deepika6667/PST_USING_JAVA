Subarray Division:
  import java.io.*;
import java.util.*;

public class Solution {

    public static int birthday(List<Integer> s, int d, int m) {
        if (s.size() < m) return 0;

        int count = 0;
        int currentSum = 0;

        // 1. Calculate the sum of the first window of size m
        for (int i = 0; i < m; i++) {
            currentSum += s.get(i);
        }

        if (currentSum == d) count++;

        // 2. Slide the window across the array
        for (int i = m; i < s.size(); i++) {
            currentSum += s.get(i) - s.get(i - m); // Add new element, subtract old element
            if (currentSum == d) count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine().trim());
        int d = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = birthday(s, d, m);
        System.out.println(result);
    }
}

OUTPUT:
Input (stdin)
5
1 2 1 3 2
3 2
Your Output (stdout)
2
Expected Output
2

  Compiler Message
Success
Input (stdin)
5
1 2 1 3 2
3 2
Expected Output
2
