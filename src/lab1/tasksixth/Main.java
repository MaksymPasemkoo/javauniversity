package lab1.tasksixth;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("Format:100 UAH into USD");
        System.out.println("Enter conversion: ");
        String input = scanner.nextLine();

        try {
            double result = converter.convertCurrency(input);
            System.out.println("Converted amount: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

