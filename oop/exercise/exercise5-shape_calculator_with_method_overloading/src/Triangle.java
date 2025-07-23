class Triangle extends Shape {

    private double sideA, sideB, sideC;
    public Triangle(String color, double sideA, double sideB, double sideC){
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getArea(){
        // heron formula
        double s = getPerimeter()/2;
        return Math.sqrt(s * (s-sideA) * (s-sideB) * (s-sideC));
    }

    @Override
    public double getPerimeter(){
        return sideA + sideB + sideC;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Triangle (%s): Sides=%.1f, %.1f, %.1f\n", color, sideA, sideB, sideC);
        System.out.printf("Area: %.2f, Perimeter: %.2f\n", getArea(), getPerimeter());
    }
}
