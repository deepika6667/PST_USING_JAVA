SESSION 6-2
SHUFFLE THE ARRAY:
public class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];       // Place x_i at even indices
            result[2 * i + 1] = nums[i + n]; // Place y_i at odd indices
        }
        return result;
    }
}
OUTPUT:
[2, 3, 5, 4, 1, 7]

=== Code Execution Successful ===
