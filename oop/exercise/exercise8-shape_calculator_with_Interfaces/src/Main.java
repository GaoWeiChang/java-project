public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(5.0, "RED");
        Rectangle rectangle = new Rectangle(4.0, 6.0, "BLUE");
        Triangle triangle = new Triangle(3.0, 4.0, 5.0,"GREEN");

        Shape[] shapes = {circle, rectangle, triangle};
        ShapeProcessor processor = new ShapeProcessor();

        processor.processShapes(shapes);


        System.out.println("=== Additional Operations ===");
        processor.findLargestShape(shapes);


        System.out.println("\n=== Interface Capabilities ===");
        for (Shape shape : shapes) {
            System.out.printf("%s: ", shape.getName());

            if (shape instanceof Drawable) {
                System.out.print("Drawable ");
            }
            if (shape instanceof Calculable) {
                System.out.print("Calculable ");
            }
            if (shape instanceof Resizable) {
                System.out.print("Resizable ");
            }
            System.out.println();
        }

        System.out.println("\n=== Validation Test ===");
        try {
            Circle invalidCircle = new Circle(-5, "BLACK");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }

        try {
            Rectangle invalidRectangle = new Rectangle(0, 5, "WHITE");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }
}
