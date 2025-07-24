public abstract class Shape implements Drawable, Calculable {
    protected String color;
    protected String name;

    public Shape(String name, String color){
        this.color = color;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean validateDimensions();

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("%s (%s): Area = %.2f, Perimeter = %.2f", name, color, calculateArea(), calculatePerimeter());
    }
}
