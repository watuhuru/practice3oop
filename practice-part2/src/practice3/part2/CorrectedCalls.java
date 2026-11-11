package practice3.part2;

public class CorrectedCalls {
    static class Circle {
        double getArea() { return Math.PI; }
    }

    private final Circle c = new Circle();

    public void method1() { method2(); }

    public void method2() {
        System.out.println("What is area " + c.getArea());
    }

    public static void main(String[] args) {
        CorrectedCalls object = new CorrectedCalls();
        object.method1();
    }
}
