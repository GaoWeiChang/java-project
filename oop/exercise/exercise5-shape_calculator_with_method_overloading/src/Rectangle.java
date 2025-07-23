class Rectangle extends Shape {

    private double length;
    private double width;

    public Rectangle(String color, double length, double width){
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea(){
        return length * width;
    }

    @Override
    public double getPerimeter(){
        return 2 * (length + width);
    }

    @Override
    public void displayInfo(){
        System.out.printf("Rectangle (%s): Width=%.1f, Height=%.1f\n", color, width, length);
        System.out.printf("Area: %.2f, Perimeter: %.2f\n", getArea(), getPerimeter());
    }
}
