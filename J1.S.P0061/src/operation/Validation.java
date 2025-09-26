package operation;

import java.util.Scanner;
import object.Triangle;

public class Validation {

    public static final Scanner sc = new Scanner(System.in);

    // Check input la so double
    public static double getDouble(String msg, double min, double max) {
        while (true) {
            System.out.println(msg);
            try {
                double res = Double.parseDouble(sc.nextLine().trim());
                if (min < res && res <= max) {
                    return res;
                }
                System.err.print("Out of range, enter again: ");
            } catch (NumberFormatException e) {
                System.err.print("Wrong fomat, please enter a number!");
            }

        }
    }
    // Kiểm tra tam giác hợp lệ

    private static boolean isValidTriangle(double a, double b, double c) {
        return (a > 0 && b > 0 && c > 0)
                && (a + b > c) && (a + c > b) && (b + c > a);
    }

    // Hàm nhập tam giác (chỉ trả về khi hợp lệ)
    public static Triangle inputTriangle() {
        while (true) {
            double a = getDouble("Enter side A: ", 0, Double.MAX_VALUE);
            double b = getDouble("Enter side B: ", 0, Double.MAX_VALUE);
            double c = getDouble("Enter side C: ", 0, Double.MAX_VALUE);

            if (isValidTriangle(a, b, c)) {
                return new Triangle(a, b, c);
            } else {
                System.err.println("These sides do not form a valid triangle. Please enter again!");
            }
        }
    }
}
