maximum subarray:
class Solution {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            max = Math.max(max, current);
        }

        return max;
    }
}
OUTPUT:
Accepted
Runtime: 0 ms
Case 1
Case 2
Case 3
Input
nums =
[-2,1,-3,4,-1,2,1,-5,4]
Output
6
Expected
6

