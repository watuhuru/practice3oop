package practice3.part2;

public class Circle {
    private final double radius;
    private static int numberOfObjects;

    public Circle(double radius) {
        if (radius < 0) throw new IllegalArgumentException("Радиус не может быть отрицательным");
        this.radius = radius;
        numberOfObjects++;
    }

    public double getRadius() { return radius; }
    public double getArea() { return Math.PI * radius * radius; }
    public static int getNumberOfObjects() { return numberOfObjects; }
}
