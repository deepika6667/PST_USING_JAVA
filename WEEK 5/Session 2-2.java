maximum-sum-circular-subarray
public class Solution {
    public static int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        
        int maxEndingHere = 0;
        int maxSubarraySum = nums[0];
        
        int minEndingHere = 0;
        int minSubarraySum = nums[0];

        for (int num : nums) {
            totalSum += num;

            // Standard Kadane's algorithm for Max Subarray Sum
            maxEndingHere = Math.max(num, maxEndingHere + num);
            maxSubarraySum = Math.max(maxSubarraySum, maxEndingHere);

            // Kadane's algorithm variant for Min Subarray Sum
            minEndingHere = Math.min(num, minEndingHere + num);
            minSubarraySum = Math.min(minSubarraySum, minEndingHere);
        }

        // If all elements are negative, maxSubarraySum is the max single negative element
        if (maxSubarraySum < 0) {
            return maxSubarraySum;
        }

        // Return the max of non-wrapped (maxSubarraySum) and wrapped (totalSum - minSubarraySum)
        return Math.max(maxSubarraySum, totalSum - minSubarraySum);
    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{1, -2, 3, -2})); // Output: 3
        System.out.println(maxSubarraySumCircular(new int[]{5, -3, 5}));     // Output: 10
        System.out.println(maxSubarraySumCircular(new int[]{-3, -2, -3}));   // Output: -2
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
[1,-2,3,-2]
Output
3
Expected
3
