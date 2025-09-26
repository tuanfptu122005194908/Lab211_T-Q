package manager;

import java.util.List;
import java.util.Scanner;
import object.Worker;

public class Validation {

    private static Scanner sc = new Scanner(System.in);

    // check input is a int number
    // Check input la so int
    public static int getInt(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (min <= result && result <= max) {
                    return result;
                }
                System.err.print("Out of range, enter again: ");
            } catch (NumberFormatException e) {
                System.err.print("Wrong fomat, please enter a number!");
            }

        }
    }

    // Check input la so double
    public static double getDouble(String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            try {
                double res = Double.parseDouble(sc.nextLine().trim());
                if (min <= res && res <= max) {
                    return res;
                }
                System.err.print("Out of range, enter again: ");
            } catch (NumberFormatException e) {
                System.err.print("Wrong fomat, please enter a number!");
            }

        }
    }

    // check input String is not empty
    public static String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.err.println("Input cannot be empty! Please enter again.");
        }
    }

    public static boolean isDuplicateId(String id, List<Worker> workers) {
        for (Worker w : workers) {
            if (w.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    // check id
    public static String getCode(String msg, List<Worker> workers) {
        while (true) {
            String code = getString(msg);
            if (isDuplicateId(code, workers)) {
                System.err.println("Code is duplicated! Enter again.");
            } else {
                return code;
            }
        }
    }
}
