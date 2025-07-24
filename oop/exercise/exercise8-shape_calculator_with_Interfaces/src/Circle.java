public class Circle extends Shape implements Resizable {
    private double radius;

    public Circle(double radius, String color){
        super("Circle", color);
        this.radius = radius;
    }

    @Override
    public boolean validateDimensions(){
        return radius > 0;
    }

    @Override
    public double calculateArea(){
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter(){
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw(){
        System.out.printf("Drawing %s Circle with radius %.1f%n", color, radius);
    }

    @Override
    public void resize(double factor) {
        if (factor > 0) {
            radius *= factor;
        }
    }

    @Override
    public boolean canResize(){
        return true;
    }
}
