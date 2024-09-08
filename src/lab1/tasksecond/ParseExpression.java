package lab1.tasksecond;

import java.util.Scanner;

public class ParseExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression:");
        double res = evaluateExpression(scanner.nextLine());
        System.out.println(res);
    }

    private static double evaluateExpression(final String expression){
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty.");
        }

        String[] parts = expression.replaceAll("[=\\?]","").split(" ");

        if(parts.length < 3){
            throw new IllegalArgumentException("Invalid expression format. Use format '<number> <operator> <number>'.");
        }

        final double num1;
        final double num2;
        try {
            num1 = Double.parseDouble(parts[0]);
            num2 = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numbers in expression.");
        }

        String choice = parts[1];

        switch(choice){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("There is no operation like: " + choice);
        }
    }
}

