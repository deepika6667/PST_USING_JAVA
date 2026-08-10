 Day of the Week:
import java.time.LocalDate;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        String dayOfWeek = date.getDayOfWeek().toString();
        // Capitalize the first letter and make the rest lowercase
        return dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1).toLowerCase();
    }
}

OUTPUT:
Input
day =
31
month =
8
year =
2019
Output
"Saturday"
Expected
"Saturday"


