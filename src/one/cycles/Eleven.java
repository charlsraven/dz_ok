package one.cycles;

import java.util.Scanner;

/**
 * Пользователь вводит целое положительное число (N).
 * Выведите числа в диапазоне от 1 до N, сумма четных цифр которых больше суммы нечетных.
 */
public class Eleven {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();

            for (int i = 1; i <= n; i++) {
                int num = i, even = 0, odd = 0;

                while (num > 0) {
                    int digit = num % 10;
                    if (digit % 2 == 0) {
                        even += digit;
                    } else {
                        odd += digit;
                    }
                    num /= 10;
                }

                if (even > odd) {
                    System.out.println(i);
                }
            }
        }
    }
}
