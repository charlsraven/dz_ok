package one.cycles;

import java.util.Scanner;

/**
 * Пользователь вводит 2 числа (A и B). Вывести сумму всех чисел из диапазона от A до B, которые делятся без остатка на 7. (Учтите, что при вводе B может оказаться меньше A).
 */
public class Five {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();
            int b = in.nextInt();
            int sum = 0;
            for (int i = a; i < b; i++) {
                if (i % 7 == 0) {
                    sum += i;
                }
            }
            System.out.println(sum);
        }
    }
}
