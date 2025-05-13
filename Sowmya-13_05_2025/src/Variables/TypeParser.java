package Variables;

import java.util.Scanner;

public class TypeParser {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a value: ");
            String input = sc.nextLine();

            // Try parsing to Integer
            try {
                int intValue = Integer.parseInt(input);
                System.out.println("Parsed as int: " + intValue);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer format.");
            }

            // Try parsing to Double
            try {
                double doubleValue = Double.parseDouble(input);
                System.out.println("Parsed as double: " + doubleValue);
            } catch (NumberFormatException e) {
                System.out.println("Invalid double format.");
            }

            // Try parsing to Boolean
            try {
                boolean booleanValue = Boolean.parseBoolean(input);
                System.out.println("Parsed as boolean: " + booleanValue);
            } catch (Exception e) {
                System.out.println("Invalid boolean format.");
            }

            // Try parsing to Long
            try {
                long longValue = Long.parseLong(input);
                System.out.println("Parsed as long: " + longValue);
            } catch (NumberFormatException e) {
                System.out.println("Invalid long format.");
            }

            // Try parsing to Float
            try {
                float floatValue = Float.parseFloat(input);
                System.out.println("Parsed as float: " + floatValue);
            } catch (NumberFormatException e) {
                System.out.println("Invalid float format.");
            }

            sc.close();
        }
    }

