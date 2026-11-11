package practice3.part2;

public class StaticMethods {
    private int count;
    public int getCount() { return count; }

    public static int factorial(int n) {
        if (n < 0 || n > 12) throw new IllegalArgumentException("Введите число от 0 до 12");
        int result = 1;
        for (int i = 1; i <= n; i++) result *= i;
        return result;
    }

    public static void main(String[] args) {
        StaticMethods object = new StaticMethods();
        System.out.println("Count: " + object.getCount());
        System.out.println("5! = " + factorial(5));
    }
}
