package view;

import java.util.Scanner;
import manager.*;
import object.BinaryNumber;
import object.DecimalNumber;
import object.HexaNumber;

public class Display {

    public static Scanner sc = new Scanner(System.in);

    private static void processBinary(int outChoice) {
        String input = Validation.checkBinary("Enter binary number: ");
        BinaryNumber bn = new BinaryNumber(input);

        if (outChoice == 1) {
            System.out.println("Convert to binary: " + input);
        } else if (outChoice == 2) {
            System.out.println("Convert to decimal: " + Convert.BinaryToDecimal(bn));
        } else {
            System.out.println("Convert to Hexadecimal: " + Convert.BinaryToHexa(bn));
        }
    }

    // xử lý Decimal input
    private static void processDecimal(int outChoice) {
        String input = Validation.checkDecimal("Enter decimal number: ");
        DecimalNumber dn = new DecimalNumber(Integer.parseInt(input));

        if (outChoice == 1) {
            System.out.println("Convert to binary: " + Convert.DecimalToBinary(dn));
        } else if (outChoice == 2) {
            System.out.println("Convert to decimal: " + input);
        } else {
            System.out.println("Convert to Hexadecimal: " + Convert.DecimalToHexa(dn));
        }
    }

    // xử lý Hexa input
    private static void processHexa(int outChoice) {
        String input = Validation.checkHexa("Enter hexadecimal number (A-F allowed): ");
        HexaNumber hn = new HexaNumber(input);

        if (outChoice == 1) {
            System.out.println("Convert to binary: " + Convert.HexaToBinary(hn));
        } else if (outChoice == 2) {
            System.out.println("Convert to decimal: " + Convert.HexaToDecimal(hn));
        } else {
            System.out.println("Convert to Hexadecimal: " + input);
        }
    }

    public static void Menu() {
        int choice;
        while (true) {
            System.out.println("=== Number Base Conversion ===");
            System.out.println("1. Binary.");
            System.out.println("2. Decimal.");
            System.out.println("3. Hexadecimal");
            System.out.println("4. Exit.");
            choice = Validation.getInt("Your choice: ", 1, 4);
            if (choice == 4) {
                System.out.println("Goodbye!");
                return;
            }

            int outChoice = Validation.getInt("Choose output base (1-Binary, 2-Decimal, 3-Hexa): ", 1, 3);
            switch (choice) {
                case 1:
                    processBinary(outChoice);
                    break;
                case 2:
                    processDecimal(outChoice);
                    break;
                case 3:
                    processHexa(outChoice);
                    break;

            }
        }

    }
}
