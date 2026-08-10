Session 10.1:
java dequeue:
import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            // Add element to deque and set
            deque.add(num);
            set.add(num);

            // Once window reaches size m
            if (deque.size() == m) {
                // Update max unique count
                if (set.size() > maxUnique) {
                    maxUnique = set.size();
                }

                // If max possible unique elements for window size m is already reached, break early
                if (maxUnique == m) {
                    break;
                }

                // Remove the oldest element (front of the queue)
                int removed = deque.removeFirst();
                
                // Only remove from set if no other instances of 'removed' exist in current deque
                if (!deque.contains(removed)) {
                    set.remove(removed);
                }
            }
        }

        System.out.println(maxUnique);
        in.close();
    }
}

OUTPUT:
Input (stdin)
6 3
5 3 5 2 3 2
Your Output (stdout)
3
Expected Output
3
