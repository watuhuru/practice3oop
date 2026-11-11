package practice3.part2;

import java.util.Date;

public class DateArray {
    public static void main(String[] args) {
        Date[] dates = new Date[10];
        System.out.println("До инициализации: " + dates[0]);
        // dates[0].toString() здесь вызовет NullPointerException.
        for (int i = 0; i < dates.length; i++) dates[i] = new Date();
        System.out.println("После инициализации: " + dates[0].toString());
    }
}
