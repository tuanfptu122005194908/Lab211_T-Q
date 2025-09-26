package program;

import java.util.ArrayList;
import java.util.Scanner;
import object.Shape;
import object.Circle;
import object.Rectangle;
import object.Square;
import object.Triangle;
import operation.Validation;

public class Main {

    public static void main(String[] args) {
        System.out.println("=====Calculator Shape Program=====");
        // nhap Rectangle
        double w = Validation.getDouble("Please input side width of Rectangle:", 0, Double.MAX_VALUE);
        double l = Validation.getDouble("Please input length of Rectangle:", 0, Double.MAX_VALUE);

        // nhap circle
        double r = Validation.getDouble("Please input radius of Circle:", 0, Double.MAX_VALUE);

        
        // nhap square
        double side = Validation.getDouble("Please input side width of Square:", 0, Double.MAX_VALUE);

        Shape rec = new Rectangle(l, w);
        rec.printResult();
        Shape circle = new Circle(r);
        circle.printResult();
        Shape tri = new Validation().inputTriangle();
        tri.printResult();
        Rectangle sq = new Square(side, side, side);
        sq.printResult();

        ArrayList<Shape> shapes = new ArrayList<>();

        // them hinh vao arraylist
        shapes.add(circle);
        shapes.add(rec);
        shapes.add(tri);
        shapes.add(sq);

        // cuoi chuong trinh
        double total = 0;
        for (Shape s : shapes) {
            total += s.getArea();
        }
        System.out.println("Total Area: " + total);
    }

}
