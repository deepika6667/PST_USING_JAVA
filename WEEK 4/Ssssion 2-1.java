BINARY SEARCH:
  import java.util.*;

public class BinarySearch {

    static int search(int[] a, int x) {
        int l = 0, r = a.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (a[m] == x)
                return m;
            else if (a[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        int x = 4;

        int result = search(a, x);

        if (result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index: " + result);
    }
}

OUTPUT:
C:\Users\Admin\Downloads>javac BinarySearch.java

C:\Users\Admin\Downloads>java BinarySearch
Element found at index: 3
