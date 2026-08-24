Maximum Subarray:
  import java.io.*;
import java.util.*;

public class Solution {
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either extend the previous subarray or start a new subarray from nums[i]
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            // Track the overall maximum sum encountered
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {1};
        int[] nums3 = {5, 4, -1, 7, 8};

        System.out.println(maxSubArray(nums1)); // Output: 6
        System.out.println(maxSubArray(nums2)); // Output: 1
        System.out.println(maxSubArray(nums3)); // Output: 23
    }
}

OUTPUT:
Input
nums =
[-2,1,-3,4,-1,2,1,-5,4]
Output
6
Expected
6

