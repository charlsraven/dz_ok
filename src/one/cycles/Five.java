package one.cycles;

import java.util.Scanner;

/**
 * Пользователь вводит 2 числа (A и B). Вывести сумму всех чисел из диапазона от A до B, которые делятся без остатка на 7.
 * (Учтите, что при вводе B может оказаться меньше A).
 */
public class Five {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();
            int b = in.nextInt();
            int start = Math.min(a, b);
            int end = Math.max(a, b);
            int sum = 0;
            for (int i = findNearestMultipleOfSeven(start); i <= end; i += 7) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    public static int findNearestMultipleOfSeven(int number) {
        if (number % 7 != 0) {
            return number + (7 - number % 7);
        }
        return number;
    }
}
/*
    Второй вариант решения:
    // Находим первое и последнее кратное 7
    int firstMultiple = (start + 6) / 7 * 7; // округление вверх до кратного 7
    int lastMultiple = end / 7 * 7;          // округление вниз до кратного 7

    if (firstMultiple > lastMultiple) return 0;

    // Формула суммы арифметической прогрессии
    int n = (lastMultiple - firstMultiple) / 7 + 1;
    return n * (firstMultiple + lastMultiple) / 2;
 */