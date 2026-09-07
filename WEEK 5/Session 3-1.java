string-to-integer-atoi:
public class Solution {
    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = 0;
        int n = s.length();

        // 1. Skip leading whitespaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        if (index == n) {
            return 0;
        }

        // 2. Check sign
        int sign = 1;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // 3. Process digits and handle overflow
        int result = 0;
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Overflow check for 32-bit signed integer limits
            if (result > Integer.MAX_VALUE / 10 || 
               (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));             // Output: 42
        System.out.println(myAtoi("   -042"));        // Output: -42
        System.out.println(myAtoi("1337c0d3"));       // Output: 1337
        System.out.println(myAtoi("0-1"));            // Output: 0
        System.out.println(myAtoi("words and 987"));  // Output: 0
        System.out.println(myAtoi("-91283472332"));   // Output: -2147483648 (Integer.MIN_VALUE)
    }
}
OUTOUT:
Accepted
Runtime: 0 ms
Case 1:
Input
s =
"42"
Output
42
Expected
42
