package practice3.part2;

public class StaticAccess {
    static class F {
        int i;
        static String s = "Общее поле";
        void imethod() { System.out.println("Метод экземпляра"); }
        static void smethod() { System.out.println("Статический метод"); }
    }

    public static void main(String[] args) {
        F f = new F();
        System.out.println(f.i); // 1: допустимо
        System.out.println(f.s); // 2: допустимо, предпочтительно F.s
        f.imethod();             // 3: допустимо
        f.smethod();             // 4: допустимо, предпочтительно F.smethod()
        // System.out.println(F.i); // 5: ошибка, i принадлежит объекту
        System.out.println(F.s); // 6: допустимо
        // F.imethod();            // 7: ошибка, нужен объект
        F.smethod();             // 8: допустимо
    }
}
