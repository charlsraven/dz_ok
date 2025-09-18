package one.cycles;

import java.util.Scanner;

/**
 * Пользователь вводит 1 число.
 * Найти число, которое является зеркальным отображением последовательности цифр заданного числа,
 * например, задано число 123, вывести 321.
 */
public class Ten {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int x = in.nextInt();
            int mirror = 0;
            while (x > 0) {
                mirror = mirror * 10 + x % 10;
                x /= 10;
            }
            System.out.println(mirror);
        }
    }
}
