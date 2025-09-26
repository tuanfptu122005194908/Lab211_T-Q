/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author DELL
 */
import model.Shape;
import model.Circle;
import model.Rectangle;
import model.Triangle;
import view.Validation;

public class Main {

    public static void main(String[] args) {

        System.out.println("=====Calculator Shape Program=====");
        double w = Validation.checkInputDouble("Please input size width of Rectangle:", 0, Double.MAX_VALUE);
        double l = Validation.checkInputDouble("Please input length of Rectangle:", 0, Double.MAX_VALUE);
        double r = Validation.checkInputDouble("Please input radius of Circle:", 0, Double.MAX_VALUE);
        double sideA = Validation.checkInputDouble("Please input size A of Triangle:", 0, Double.MAX_VALUE);
        double sideB = Validation.checkInputDouble("Please input size B of Triangle:", 0, Double.MAX_VALUE);
        double sideC = Validation.checkInputDouble("Please input size C of Triangle:", 0, Double.MAX_VALUE);
        Shape rec = new Rectangle(l, w);
        rec.prinResult();

        Shape c = new Circle(r);
        c.prinResult();

        Shape tri = new Triangle(sideA, sideB, sideC);
        tri.prinResult();
    }

}
