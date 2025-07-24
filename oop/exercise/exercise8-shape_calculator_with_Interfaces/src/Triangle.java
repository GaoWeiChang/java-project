public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3, String color){
        super("Triangle", color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public boolean validateDimensions(){
        return side1 > 0 & side2 > 0 & side3 > 0;
    }

    @Override
    public double calculateArea(){
        double s = calculatePerimeter()/2;
        return Math.sqrt(s * (s-side1) * (s-side2) * (s-side3));
    }

    @Override
    public double calculatePerimeter(){
        return side1 + side2 + side3;
    }

    @Override
    public void draw(){
        System.out.printf("Drawing %s Triangle with side1: %.1f and side2: %.1f and side3: %.1f\n", color, side1, side2, side3);
    }
}