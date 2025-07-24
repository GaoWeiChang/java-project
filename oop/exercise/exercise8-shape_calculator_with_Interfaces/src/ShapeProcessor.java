public class ShapeProcessor {

    public void processShapes(Shape[] shapes){
        System.out.println("=== Shape Analysis ===");

        double totalArea = 0;
        for(Shape shape: shapes){
            System.out.println(shape);
            totalArea += shape.calculateArea();
        }

        System.out.printf("Total Area: %.2f%n%n", totalArea);
    }

    public void resizeAllShapes(Shape[] shapes, double factor) {
        System.out.println("=== Resize Operation ===");

        for (Shape shape : shapes) {
            if (shape instanceof Resizable) {
                Resizable resizableShape = (Resizable) shape;
                if (resizableShape.canResize()) {
                    double oldArea = shape.calculateArea();
                    resizableShape.resize(factor);
                    double newArea = shape.calculateArea();
                    System.out.printf("%s resized by %.1fx: New Area = %.2f%n",
                            shape.getName(), factor, newArea);
                }
            } else {
                System.out.printf("%s cannot be resized%n", shape.getName());
            }
        }
        System.out.println();
    }

    public void drawAllShapes(Shape[] shapes) {
        System.out.println("=== Drawing Shapes ===");
        for (Shape shape : shapes) {
            shape.draw();
        }
        System.out.println();
    }

    public double calculateTotalArea(Shape[] shapes) {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.calculateArea();
        }
        return total;
    }

    public void findLargestShape(Shape[] shapes) {
        if (shapes.length == 0) return;

        Shape largest = shapes[0];
        for (Shape shape : shapes) {
            if (shape.calculateArea() > largest.calculateArea()) {
                largest = shape;
            }
        }

        System.out.printf("Largest Shape: %s with area %.2f%n",
                largest.getName(), largest.calculateArea());
    }
}
