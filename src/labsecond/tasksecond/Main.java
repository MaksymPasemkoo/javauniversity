package labsecond.tasksecond;

public class Main {
    public static void main(String[] args) {
        Shape triangle = new Triangle(3, 4);
        Shape square = new Square(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape cube = new Cube(5);
        Shape circle = new Circle(5);
        Shape sphere = new Sphere(5);
        Shape pyramid = new Pyramid(5, 5, 5);


        System.out.println("Pyramid Area: " + pyramid.calculateArea());
        System.out.println("Pyramid Volume: " + pyramid.calculateVolume());

    }
}
