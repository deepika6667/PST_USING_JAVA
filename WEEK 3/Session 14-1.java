LARGEST NUMBER:
  import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];

        // Convert integers to strings
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Sort so that b+a comes before a+b
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is 0, return "0"
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build the result
        StringBuilder result = new StringBuilder();

        for (String s : arr) {
            result.append(s);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] nums1 = {10, 2};
        System.out.println(obj.largestNumber(nums1));

        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println(obj.largestNumber(nums2));
    }
}


OUTPUT:
Input
nums =
[10,2]
Output
"210"
Expected
"210"
