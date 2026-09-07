find And Replace Pattern:
import java.util.*;

public class Solution {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        
        return result;
    }

    private static boolean matches(String word, String pattern) {
        int[] pToW = new int[26]; // Pattern character to Word character
        int[] wToP = new int[26]; // Word character to Pattern character

        for (int i = 0; i < pattern.length(); i++) {
            char pChar = pattern.charAt(i);
            char wChar = word.charAt(i);

            int pIdx = pChar - 'a';
            int wIdx = wChar - 'a';

            // Check if mapping already exists and conflicts
            if (pToW[pIdx] == 0 && wToP[wIdx] == 0) {
                pToW[pIdx] = wChar;
                wToP[wIdx] = pChar;
            } else if (pToW[pIdx] != wChar || wToP[wIdx] != pChar) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words1 = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern1 = "abb";
        System.out.println(findAndReplacePattern(words1, pattern1)); 
        // Output: ["mee", "aqq"]

        String[] words2 = {"a", "b", "c"};
        String pattern2 = "a";
        System.out.println(findAndReplacePattern(words2, pattern2)); 
        // Output: ["a", "b", "c"]
    }
}
OUTPUT:
Input
words =
["abc","deq","mee","aqq","dkd","ccc"]
pattern =
"abb"
Output
["mee","aqq"]
Expected
["mee","aqq"]
