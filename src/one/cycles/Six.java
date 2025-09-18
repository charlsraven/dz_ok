package one.cycles;

import java.util.Scanner;

/**
 * Пользователь вводит 1 положительное число (N).
 * Выведите N-ое число ряда фибоначчи.
 * В ряду фибоначчи каждое следующее число является суммой двух предыдущих.
 * Первое и второе считаются равными 1.
 */
public class Six {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int a = 1;
            int b = 1;

            for (int i = 2; i < n; i++) {
                b = a + b;
                a = b - a;
            }
        }
    }
}
