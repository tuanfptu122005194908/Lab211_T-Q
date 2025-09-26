package manager;

import java.util.Scanner;

public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static int checkInput(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n > 0) {
                    return n;
                }
                System.err.println("Please enter a integer number!");
            } catch(NumberFormatException e){
                System.err.println("Wrong fomat! Please enter a number!");
            }
        }
    }
}
