package View;

import java.util.*;
import object.*;
import manager.*;

public class Menu {

    public void menu() {
        int choice;
        while (true) {
            System.out.println("===== Calculator program =====");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Exit program");
            choice = validation.getChoice("Your choice: ", 1, 4);
            if (choice == 4) {
                System.out.println("Exit program!");
                return;
            }

            switch (choice) {
                case 1:
                    System.out.println("-------- Addition --------");
                    Matrix addM1 = validation.inputMatrix("Matrix1");
                    Matrix addM2 = validation.inputMatrix("Matrix2");
                    Matrix addResult = MatrixManager.addMatrix(addM1, addM2);
                    if (addResult != null) {
                        System.out.println("-------- Result --------");
                        addM1.display();
                        System.out.println("+");
                        addM2.display();
                        System.out.println("=");
                        addResult.display();
                    }
                    break;
                case 2:
                    System.out.println("-------- Subtraction --------");
                    Matrix subM1 = validation.inputMatrix("Matrix1");
                    Matrix subM2 = validation.inputMatrix("Matrix2");
                    Matrix subResult = MatrixManager.subtractionMatrix(subM1, subM2);
                    if (subResult != null) {
                        System.out.println("-------- Result --------");
                        subM1.display();
                        System.out.println("-");
                        subM2.display();
                        System.out.println("=");
                        subResult.display();
                    }
                    break;
                case 3:
                    System.out.println("-------- Multiplication --------");
                    Matrix mulM1 = validation.inputMatrix("Matrix1");
                    Matrix mulM2 = validation.inputMatrix("Matrix2");
                    Matrix mulResult = MatrixManager.multiplicationMatrix(mulM1, mulM2);
                    if (mulResult != null) {
                        System.out.println("-------- Result --------");
                        mulM1.display();
                        System.out.println("x");
                        mulM2.display();
                        System.out.println("=");
                        mulResult.display();
                    }
                    break;

            }
        }

    }
}
