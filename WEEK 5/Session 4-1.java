length Of Longest Substring:
import java.util.*;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        
        // Map to store character -> its last seen index
        Map<Character, Integer> charMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character is inside current window, jump left pointer forward
            if (charMap.containsKey(currentChar)) {
                left = Math.max(left, charMap.get(currentChar) + 1);
            }

            charMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // Output: 3 ("abc")
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // Output: 1 ("b")
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // Output: 3 ("wke")
    }
}
OUTPUT:
Accepted
Runtime: 0 ms
Case 1
Input
s =
"abcabcbb"
Output
3
Expected
3
