public class Rectangle extends Shape implements Resizable {
    private double width;
    private double length;

    public Rectangle(double length, double width, String color){
        super("Rectangle", color);
        this.width = width;
        this.length = length;
    }

    @Override
    public boolean validateDimensions(){
        return length > 0 && width > 0;
    }

    @Override
    public double calculateArea(){
        return width * length;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + length);
    }

    @Override
    public void draw(){
        System.out.printf("Drawing %s Rectangle with width: %.1f and length: %.1f\n", color, width, length);
    }

    @Override
    public void resize(double factor){
        if (factor > 0) {
            length *= factor;
            width *= factor;
        }
    }

    @Override
    public boolean canResize() {
        return true;
    }
}
