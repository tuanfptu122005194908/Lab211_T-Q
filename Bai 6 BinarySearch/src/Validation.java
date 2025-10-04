import java.util.Scanner;

public class Validation {
    private Scanner sc = new Scanner(System.in);
    
    public int getPositiveInteger(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int n = Integer.parseInt(sc.nextLine());
                if (n > 0) {
                    return n;
                }
                System.out.println("Please enter a positive number!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number!");
            }
        }
    }
    
    public int getInteger(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number!");
            }
        }
    }
}