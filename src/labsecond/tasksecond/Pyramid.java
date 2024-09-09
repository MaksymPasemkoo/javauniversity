package labsecond.tasksecond;

class Pyramid extends Shape {
    private final double side;
    private final double height;
    private final double apothem;

    public Pyramid(double side, double height, double apothem) {
        this.side = side;
        this.height = height;
        this.apothem = apothem;
    }

    @Override
    public double calculateArea() {
        double baseArea = side * side;
        double sideArea = 4 * (0.5 * side * apothem);
        return baseArea + sideArea;
    }

    @Override
    public double calculateVolume() {
        return (1.0 / 3.0) * side * side * height;
    }
}