package manager;

import java.util.Scanner;

public class Validation {

    private static Scanner sc = new Scanner(System.in);

    private static final String BINARY_VALID = "[0-1]+";
    private static final String DECIMAL_VALID = "[0-9]+";
    private static final String HEXA_VALID = "[0-9A-F]+";

    public static int getInt(String msg, int min, int max) {
        System.out.print(msg);
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n >= min && n <= max) {
                    return n;
                }
                System.err.println("Please enter a int number! ");
            } catch (NumberFormatException e) {
                System.err.println("Wrong fomat! Please try again ");
            }
        }
    }

    public static String checkBinary(String msg) {
        System.out.print(msg);
        while (true) {
            String input = sc.nextLine().trim();
            if (input.matches(BINARY_VALID)) {
                return input;
            }
            System.err.println("Wrong! Please enter again! ");
        }
    }

    public static String checkDecimal(String msg) {
        System.out.print(msg);
        while (true) {
            String input = sc.nextLine().trim();
            if (input.matches(DECIMAL_VALID)) {
                return input;
            }
            System.err.println("Please try again! ");
        }
    }

    public static String checkHexa(String msg) {
        System.out.print(msg);
        while (true) {
            String input = sc.nextLine().trim();
            if (input.matches(HEXA_VALID)) {
                return input;
            }
            System.err.println("Please try again! ");
        }
    }
    
    
}
