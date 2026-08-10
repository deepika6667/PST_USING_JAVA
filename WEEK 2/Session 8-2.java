SESSION 8.2:
FIND THE HIGHEST ALTITUDE:
class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currentAltitude = 0;

        for (int i = 0; i < gain.length; i++) {
            currentAltitude += gain[i];
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }
}
OUTPUT:
Max Altitude: 1
Max Altitude: 0

=== Code Execution Successful ===
