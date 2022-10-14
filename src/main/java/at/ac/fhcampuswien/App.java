package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Seed für Aufgabe 2: ");
        long seed = scanner.nextLong();
        long [] lcgResult = lcg(seed);

        System.out.println("Ergebnisse:");
        for ( long l: lcgResult ) {
            System.out.println(l);
        }

        System.out.println("Task 3:");
        guessingGame(randomNumberBetweenOneAndHundred());
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
    }

    /*
    Task 1
    One-Month Calendar
     */
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

    /*
    Task 2
    Pseudo Random Numbers
     */
    public static long[] lcg (long seed)
    {
        final long m = (long) Math.pow(2, 31);
        final int c = 12345;
        final  int a = 1103515245;

        long[] results = new long[10];

        // Erste Berechnung mittels Startwert
        results[0] = (a * seed + c) % m;

        // Start bei 1, da 0 schon berechnet wurde
        for (int i = 1; i < results.length; i++) {
            results[i] = (a * results[i-1] + c) % m;
        }

        return results;
    }

    /*
    Task 3
    Guessing Game
     */
    //region Methods Task 2
    public static void guessingGame(int numberToGuess)
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        for (int i = 1; i <= 10; i++) {
            System.out.println("Guess number " + i + ": ");
            userInput = scanner.nextInt();

            if (i == 10 && userInput != numberToGuess)
            {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                return;
            }

            if (userInput > numberToGuess)
            {
                System.out.println("The number AI picked is lower than your guess.");
            }
            else if (userInput < numberToGuess)
            {
                System.out.println("The number AI picked is higher than your guess.");
            }
            else
            {
                System.out.println("You won wisenheimer!");
                return;
            }
        }
    }

    public static int randomNumberBetweenOneAndHundred ()
    {
        Random rnd = new Random();
        return rnd.nextInt(100) + 1;
        //rnd.Next int erstellt Zahlen von 0 bis 99. Durch das +1 bekommen wir Zahlen von 1 bis 100.
    }
    //endregion

    //region Private methods Task 1
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