package practice3.part2;

import java.util.Random;

public class SelectionSortDemo {
    public static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numbers.length; j++)
                if (numbers[j] < numbers[minIndex]) minIndex = j;
            int temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[100_000];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) numbers[i] = random.nextInt();
        StopWatch watch = new StopWatch();
        watch.start();
        selectionSort(numbers);
        watch.stop();
        System.out.println("Время сортировки 100 000 чисел: " + watch.getElapsedTime() + " мс.");
    }
}
