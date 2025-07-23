import java.util.ArrayList;

public class ShapeCalculator {
    // method overloading

    public double calculateArea(Shape shape) {
        return shape.getArea();
    }

    public double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    public double calculateArea(double length, double width) {
        return length * width;
    }

    public double calculateArea(double sideA, double sideB, double sideC) {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    public double calculateTotalArea(ArrayList<Shape> shapes){
        double total = 0;
        for (Shape shape : shapes){
            total += shape.getArea();
        }

        return total;
    }
}
