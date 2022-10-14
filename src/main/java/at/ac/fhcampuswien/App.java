package at.ac.fhcampuswien;

public class App {

    // Implement all methods as public static

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
    }

    public static void oneMonthCalendar(int daysInMonth, int monthBeginDay)
    {
        int currentDay = 1;
        final int weekLength = 7;
        int currentWeekLength = weekLength - monthBeginDay + 1;

        System.out.print(generateBeginMonthWhiteSpace(monthBeginDay));

        do
        {
            System.out.println(generateWeekRow(currentDay, currentWeekLength, daysInMonth));
            currentDay += currentWeekLength;
            currentWeekLength = weekLength;
        }
        while (currentDay <= daysInMonth);
    }

    //region Private functions Task 1
    private static String generateBeginMonthWhiteSpace (int monthBeginDay)
    {
        StringBuilder output = new StringBuilder();
        String threeSpaces = "   ";
        for (int i = 0; i < monthBeginDay - 1; i++) {
            output.append(threeSpaces);
        }

        return output.toString();
    }

    private static String generateWeekRow (int firstDayInRow, int weekLength, int daysInMonth)
    {
        int currentDay = firstDayInRow;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < weekLength; i++) {
            if(currentDay > daysInMonth)
            {
                return output.toString();
            }
            if (currentDay < 10)
            {
                output.append(" ").append(currentDay).append(" ");
            }
            else
            {
                output.append(currentDay).append(" ");
            }
            currentDay ++;
        }

        return output.toString();
    }
    //endregion
}