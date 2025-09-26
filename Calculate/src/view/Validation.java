/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Validation {

    public static Scanner sc = new Scanner(System.in);

    public static double checkInputDouble(String msg, double min, double max) {
        System.out.println(msg);
        while (true) {
            try {
                double res = Double.parseDouble(sc.nextLine().trim());
                if (res > min && res <= max) {
                    return res;
                }
                System.err.print("Please enter a real number: ");
            } catch (NumberFormatException e) {
                System.err.print("Wrong fomat! Enter again: ");
            }
        }
    }
}
