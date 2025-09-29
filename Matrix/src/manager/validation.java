package manager;

import java.util.*;
import object.*;

public class validation {

    private static Scanner sc = new Scanner(System.in);

    // check input la so int 
    public static int getInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                int res = Integer.parseInt(sc.nextLine().trim());
                if (res > 0) {
                    return res;
                }
                System.err.println("Please enter a int number!");
            } catch (NumberFormatException e) {
                System.err.println("Value of matrix is digit");
            }
        }
    }

    // check choice
    public static int getChoice(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int res = Integer.parseInt(sc.nextLine().trim());
                if (res >= min && res <= max) {
                    return res;
                }
                System.err.println("Please enter a int number!");
            } catch (NumberFormatException e) {
                System.err.println("Wrong fomat! Please enter a number! ");
            }
        }
    }

    // nhap 1 ma tran
    public static Matrix inputMatrix(String name) {
        // cai name la de dat ten cho matrix
        int row = getInt("Enter Row " + name + ": ");
        int col = getInt("Enter Column " + name + ": ");
        Matrix m = new Matrix(row, col);

        // dung vong lap de nhap tung phan tu trong matrix
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int val = getInt("Enter " + name + "[" + (i + 1) + "][" + (j + 1) + "]: ");
                m.setValue(i, j, val);
                // gan cac gia tri vua nhap vao ma tran
            }
        }
        return m;

    }
}
