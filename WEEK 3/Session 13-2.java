Java Arraylist:
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = scan.nextInt();
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                row.add(scan.nextInt());
            }
            lines.add(row);
        }
        
        int q = scan.nextInt();
        for (int i = 0; i < q; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            try {
                System.out.println(lines.get(x - 1).get(y - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }
        scan.close();
    }
}

OUTPUT:
Input (stdin)
5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5
Your Output (stdout)
74
52
37
ERROR!
ERROR!
Expected Output
74
52
37
ERROR!
ERROR!


