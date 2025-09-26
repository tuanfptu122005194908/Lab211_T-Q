package object;

public class Rectangle extends Shape {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        if (length < width) {
            // hoan doi cho nhau
            double temp = length;
            length = width;
            width = temp;
        }

        this.length = length;
        this.width = width;
    }

    @Override
    public double getPerimeter() {

        return (length + width) * 2;

    }

    @Override
    public double getArea() {

        return length * width;
    }

    @Override
    public void printResult() {
        System.out.println("-----Rectangle-----");
        System.out.println("Width: " + width);
        System.out.println("Length: " + length);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

}
