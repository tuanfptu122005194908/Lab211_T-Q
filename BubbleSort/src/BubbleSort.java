
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

    /**
     *
     * @author Tuấn và Quân
     */
    public static final Scanner sc = new Scanner(System.in);

    // check input of user (Cach 1)
    public static int checkInputInt() {

        int result;
        do {
            try {

                result = Integer.parseInt(sc.nextLine().trim());
                if (result <= 0) {
                    System.err.print("Please enter a positive integer: ");
                    result = -1;
                }
            } catch (NumberFormatException e) {
                System.err.print("Enter again: ");
                result = -1;
            }

        } while (result <= 0);
        return result;


        /*   Cach 2: 
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result > 0) {
                    return result;
                }
                System.err.print("Please enter a positive integer: ");
            } catch (NumberFormatException e) {
                System.err.print("Enter again: ");
            }
        }
         */
    }

    // allow user input a number of array
    public static int inputSizeOfArray() {
        System.out.println("Enter number of array:");
        int n = checkInputInt();
        return n;
    }

    // Generate random integer in number range for each array element.
    public static int[] generateRandomInt(int n) {
        Random rand = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            // random number from -50 to 50
            a[i] = rand.nextInt(101) - 50;
        }
        return a;
    }

    // swap 2 elements of array
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // sort array by bubble sort
    public static void sortArrayByBubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    // display
    public static void display(String msg, int[] a) {
        System.out.print(msg);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
