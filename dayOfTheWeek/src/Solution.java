import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.GregorianCalendar;
import java.util.Locale;

class Solution {

    public String dayOfTheWeek(int day, int month, int year) {
        Calendar calendar = new GregorianCalendar(year, month-1, day);
        SimpleDateFormat format = new SimpleDateFormat("EEEE", Locale.ENGLISH);

        return format.format(calendar.getTime());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dayOfTheWeek(18, 7, 1999));
    }
}

//    Given a date, return the corresponding day of the week for that date.
//
//        The input is given as three integers representing the day, month and year respectively.
//
//        Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
//
//
//
//        Example 1:
//
//        Input: day = 31, month = 8, year = 2019
//        Output: "Saturday"
//        Example 2:
//
//        Input: day = 18, month = 7, year = 1999
//        Output: "Sunday"
//        Example 3:
//
//        Input: day = 15, month = 8, year = 1993
//        Output: "Sunday"
//
//
//        Constraints:
//
//        The given dates are valid dates between the years 1971 and 2100.