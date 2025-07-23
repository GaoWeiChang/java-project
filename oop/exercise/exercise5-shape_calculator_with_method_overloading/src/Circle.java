class Circle extends Shape{

    private double radius;
    private static final double PI = Math.PI;
    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea(){
        return PI * radius * radius;
    }

    @Override
    public double getPerimeter(){
        return 2 * PI * radius;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Circle (%s): Radius=%.1f%n", color, radius);
        System.out.printf("Area: %.2f, Perimeter: %.2f%n", getArea(), getPerimeter());
    }
}
