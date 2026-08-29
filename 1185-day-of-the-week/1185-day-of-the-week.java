class Solution {
    public String dayOfTheWeek(int day, int month, int year) {

        String[] days = {
            "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"
        };

        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        // Count total days from January 1, 1971
        int totalDays = 0;

        // Add days for all previous years
        for (int y = 1971; y < year; y++) {
            if (isLeapYear(y)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        // Update February for leap year
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        // Add days for previous months
        for (int m = 0; m < month - 1; m++) {
            totalDays += daysInMonth[m];
        }

        // Add days in the current month
        totalDays += day - 1;

        // January 1, 1971 was Friday
        // Sunday = 0, Monday = 1, ..., Friday = 5
        return days[(totalDays + 5) % 7];
    }

    public boolean isLeapYear(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}