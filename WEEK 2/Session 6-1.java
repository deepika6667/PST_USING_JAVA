WEEK 2:
SESSION 6.1
BUILD ARRAY FROM PERMUTATION:
class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }
}
output:
[0, 1, 2, 4, 5, 3]

=== Code Execution Successful ===
