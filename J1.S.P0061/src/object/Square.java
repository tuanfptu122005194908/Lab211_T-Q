/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

/**
 *
 * @author DELL
 */
public class Square extends Rectangle{
    private double side;

    public Square(double length, double width, double side) {
        super(side, side);
        this.side = side;
    }
    
    public String getName(){
        return "Square";
    }
    
    @Override
    public void printResult() {
        System.out.println("-----Square-----");
        System.out.println("Side: " + side);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
    
}
