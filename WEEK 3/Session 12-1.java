 Day of the Year:
import java.time.LocalDate;

class Solution {
    public int dayOfYear(String date) {
        LocalDate d = LocalDate.parse(date);
        return d.getDayOfYear();
    }
}

OUTPUT:
Input
date =
"2019-01-09"
Output
9
Expected
9


