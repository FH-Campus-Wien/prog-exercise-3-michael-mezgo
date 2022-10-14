package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Seed für Aufgabe 2: ");
        long seed = scanner.nextLong();
        long[] lcgResult = lcg(seed);

        System.out.println("Ergebnisse:");
        for (long l : lcgResult) {
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
    public static void oneMonthCalendar(int daysInMonth, int monthBeginDay) {
        int currentDay = 1;
        final int weekLength = 7;
        int currentWeekLength = weekLength - monthBeginDay + 1;

        System.out.print(generateBeginMonthWhiteSpace(monthBeginDay));

        do {
            System.out.println(generateWeekRow(currentDay, currentWeekLength, daysInMonth));
            currentDay += currentWeekLength;
            currentWeekLength = weekLength;
        } while (currentDay <= daysInMonth);
    }

    /*
    Task 2
    Pseudo Random Numbers
     */
    public static long[] lcg(long seed) {
        final long m = (long) Math.pow(2, 31);
        final int c = 12345;
        final int a = 1103515245;

        long[] results = new long[10];

        // Erste Berechnung mittels Startwert
        results[0] = (a * seed + c) % m;

        // Start bei 1, da 0 schon berechnet wurde
        for (int i = 1; i < results.length; i++) {
            results[i] = (a * results[i - 1] + c) % m;
        }

        return results;
    }

    /*
    Task 3
    Guessing Game
     */
    //region Methods Task 2
    public static void guessingGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        for (int i = 1; i <= 10; i++) {
            System.out.println("Guess number " + i + ": ");
            userInput = scanner.nextInt();

            if (i == 10 && userInput != numberToGuess) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                return;
            }

            if (userInput > numberToGuess) {
                System.out.println("The number AI picked is lower than your guess.");
            } else if (userInput < numberToGuess) {
                System.out.println("The number AI picked is higher than your guess.");
            } else {
                System.out.println("You won wisenheimer!");
                return;
            }
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random rnd = new Random();
        return rnd.nextInt(100) + 1;
        //rnd.Next int erstellt Zahlen von 0 bis 99. Durch das +1 bekommen wir Zahlen von 1 bis 100.
    }
    //endregion

    /*
    Task 4
    Swap Arrays
     */
    public static boolean swapArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) //Arrays ungleich lang
            return false;

        for (int i = 0; i < array1.length; i++) {
            int tmp = array1[i];
            array1[i] = array2[i];
            array2[i] = tmp;
        }
        return true;
    }

    /*
    Task 5
    CamelCase
     */
    public static String camelCase(String input) {
        char[] inputArray = input.toCharArray();
        StringBuilder output = new StringBuilder();

        /*
        ASCII: (https://www.torsten-horn.de/techdocs/ascii.htm)
        A-Z = 65 - 90
        a-z = 97 - 122

        Unterschied Kleinbuchstabe - Großbuchstabe = 32

        Leerzeichen = 32 (https://de.wikipedia.org/wiki/Leerzeichen)
         */

        // Erstes Zeichen
        if (inputArray[0] < 65 || inputArray[0] > 90) {
            if (inputArray[0] >= 97 && inputArray[0] <= 122) {
                char firstCharacter = (char) ((int) inputArray[0] - 32);
                output.append(firstCharacter);
            }
        }

        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] >= 65 && inputArray[i] <= 90) // Grossbuchstaben
            {
                if (inputArray[i - 1] != ' ') // Wenn vorheriger Buchstabe kein Leerzeichen war --> kein neues Wort
                {
                    char character = (char) ((int) inputArray[i] + 32); // Großbuchstabe wird zu Kleinbuchstabe
                    output.append(character);
                } else // falls es ein neues Wort ist, wird der Großbuchstabe hinzugefügt
                {
                    output.append(inputArray[i]);
                }
            } else if (inputArray[i] >= 97 && inputArray[i] <= 122) // Kleinbuchstaben
            {
                if (inputArray[i - 1] == ' ') // Wenn vorheriger Buchstabe ein Leerzeichen war --> neues Wort
                {
                    char character = (char) ((int) inputArray[i] - 32); // Kleinbuchstabe wird zu Großbuchstabe
                    output.append(character);
                } else // falls kein neues Wort wird der Kleinbuchstabe den Output einfach so hinzugefügt
                {
                    output.append(inputArray[i]);
                }
            }
            // alle anderen Zeichen werden ignoriert
        }

        return output.toString();
    }

    /*
    Task 6
    Check Digit
     */
    public static int checkDigit(int[] code) {
        int sum = 0;

        // Gewichtung berechnen
        for (int i = 0; i < code.length; i++) {
            sum += code[i] * (i + 2);
        }

        int mod = sum % 11;

        int checkDigit = 11 - mod;

        if (checkDigit == 11) return 5;

        if (checkDigit == 10) return 0;

        return checkDigit;
    }

    //region Private methods Task 1
    private static String generateBeginMonthWhiteSpace(int monthBeginDay) {
        StringBuilder output = new StringBuilder();
        String threeSpaces = "   ";
        for (int i = 0; i < monthBeginDay - 1; i++) {
            output.append(threeSpaces);
        }

        return output.toString();
    }

    private static String generateWeekRow(int firstDayInRow, int weekLength, int daysInMonth) {
        int currentDay = firstDayInRow;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < weekLength; i++) {
            if (currentDay > daysInMonth) {
                return output.toString();
            }
            if (currentDay < 10) {
                output.append(" ").append(currentDay).append(" ");
            } else {
                output.append(currentDay).append(" ");
            }
            currentDay++;
        }

        return output.toString();
    }
    //endregion
}