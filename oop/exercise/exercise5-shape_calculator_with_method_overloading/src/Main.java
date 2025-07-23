import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create different shapes
        Rectangle rectangle = new Rectangle("Red", 3.0, 5.0);
        Circle circle = new Circle("Blue", 4.0);
        Triangle triangle = new Triangle("Green", 3.0, 4.0, 5.0);

        System.out.println("=== SHAPE CALCULATOR ===");

        rectangle.displayInfo();
        System.out.println();

        circle.displayInfo();
        System.out.println();

        triangle.displayInfo();
        System.out.println();



        System.out.println("=== POLYMORPHISM DEMO ===");
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(rectangle);
        shapes.add(circle);
        shapes.add(triangle);

        // print class name
        for (Shape shape : shapes) {
            System.out.printf("%s area: %.2f\n", shape.getClass().getSimpleName(), shape.getArea());
        }
        System.out.println();




        System.out.println("=== METHOD OVERLOADING DEMO ===");
        ShapeCalculator calculator = new ShapeCalculator();

        double circleArea = calculator.calculateArea(4.0);
        double rectArea = calculator.calculateArea(5.0, 3.0);
        double triangleArea = calculator.calculateArea(3.0, 4.0, 5.0);

        System.out.printf("Circle area (using overloaded method): %.2f\n", circleArea);
        System.out.printf("Rectangle area (using overloaded method): %.2f\n", rectArea);
        System.out.printf("Triangle area (using overloaded method): %.2f\n", triangleArea);
        System.out.println();

        // Calculate total area using polymorphism
        double totalArea = calculator.calculateTotalArea(shapes);
        System.out.printf("Total area of all shapes: %.2f%n", totalArea);
    }
}
