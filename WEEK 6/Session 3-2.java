Find all anagrams in a string:
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        // Count characters in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int k = p.length();

        // Sliding window
        for (int i = 0; i < s.length(); i++) {
            windowCount[s.charAt(i) - 'a']++;

            // Keep window size equal to p.length()
            if (i >= k) {
                windowCount[s.charAt(i - k) - 'a']--;
            }

            // Check if current window is an anagram
            if (i >= k - 1 && Arrays.equals(pCount, windowCount)) {
                result.add(i - k + 1);
            }
        }

        return result;
    }
}
OUTPUT:
Input
s =
"cbaebabacd"
p =
"abc"
Output
[0,6]
Expected
[0,6]
