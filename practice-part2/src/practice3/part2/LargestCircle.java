package practice3.part2;

public class LargestCircle {
    public static void main(String[] args) {
        Circle[] circles = {new Circle(2), new Circle(5), new Circle(3), new Circle(7), new Circle(4)};
        Circle largest = circles[0];
        for (Circle circle : circles) {
            System.out.printf("Радиус: %.2f; площадь: %.2f%n", circle.getRadius(), circle.getArea());
            if (circle.getArea() > largest.getArea()) largest = circle;
        }
        System.out.printf("Наибольшая площадь: %.2f (радиус %.2f)%n",
                largest.getArea(), largest.getRadius());
        System.out.println("Создано объектов: " + Circle.getNumberOfObjects());
    }
}
