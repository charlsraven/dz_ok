package one.cycles;

import java.util.Scanner;

/**
 * Пользователь вводит 2 числа.
 * Сообщите, есть ли в написании двух чисел одинаковые цифры.
 * Например, для пары 123 и 3456789, ответом будет являться “ДА”, а, для пары 500 и 99 - “НЕТ”.
 */
public class Twelve {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(common(a, b) ? "ДА" : "НЕТ");
        }
    }

    private static boolean common(int a, int b) {
        boolean[] digits = new boolean[10];

        while (a > 0) {
            int digit = a % 10;
            digits[digit] = true;
            a /= 10;
        }

        while (b > 0) {
            int digit = b % 10;
            if (digits[digit]) {
                return true;
            }
            b /= 10;
        }
        return false;
    }
}
