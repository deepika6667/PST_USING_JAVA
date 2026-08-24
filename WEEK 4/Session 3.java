writing efficient code:
import java.io.*;
import java.util.*;

public class FastIO {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);

        System.out.println("Type an integer and press Enter:");
        
        String input = next();
        if (input != null) {
            int n = Integer.parseInt(input);
            out.println("Output: " + n);
        }

        out.flush(); // REQUIRED: Forces the buffer to display output
    }
}

OUTPUT:
C:\Users\Admin\Downloads>javac FastIO.java

C:\Users\Admin\Downloads>java FastIO
Type an integer and press Enter:
90
Output: 90
