package labfirst.taskfifth;

import java.util.Scanner;

public class CountInSubstring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = {
                {"0", "1", "1qq", "1"},
                {"0", "1", "1qq123qq234q21qqqq", "1"},
                {"0", "1", "0", "1"},
                {"0", "1", "0", "1"}
        };

        System.out.print("Enter substring to search: ");
        String substring = scanner.nextLine();

        try {
            final int count = countSubstringInMatrix(matrix, substring);
            System.out.println("Number of occurrences: " + count);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int countSubstringInMatrix(final String[][] matrix, final String substring) {
        if (matrix == null || substring == null || substring.isEmpty()) {
            throw new IllegalArgumentException("Matrix or substring cannot be null or empty.");
        }

        int count = 0;
        int fromIndex = 0;
        for (String[] row : matrix) {
            for (String element : row) {
                while ((fromIndex = element.indexOf(substring, fromIndex)) != -1) {
                    count++;
                    fromIndex += substring.length();
                }
            }
        }
        return count;
    }
}


