package one.cycles;

import java.util.Scanner;

/**
 * Пользователь вводит 1 число. Найти количество нечетных цифр этого числа.
 */
public class Nine {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int x = in.nextInt();
            int count = 0;
            while (x > 0) {
                if (x % 10 % 2 == 1) {
                    count++;
                }
                x /= 10;
            }
            System.out.println(count);
        }
    }
}
