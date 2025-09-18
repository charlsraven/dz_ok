package one.branching;

import java.util.Scanner;

/**
 * Написать программу, которая печатает True или False в зависимости от того, выполняются или нет заданные условия:
 * •	квадрат заданного трехзначного числа равен кубу суммы цифр этого числа;
 * •	сумма двух первых цифр заданного четырехзначного числа равна сумме двух его последних цифр;
 * •	среди цифр заданного трехзначного числа есть одинаковые;
 * •	среди первых трех цифр из дробной части заданного положительного вещественного числа есть цифра 0.
 */
public class Seven {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println(first(in.nextInt()));
            System.out.println(second(in.nextInt()));
            System.out.println(third(in.nextInt()));
            System.out.println(fourth(in.nextDouble()));
        }
    }

    private static boolean first(final int x) {
        int sum = 0;
        int copy = x;
        while (copy > 0) {
            sum += copy % 10;
            copy /= 10;
        }
        return Math.sqrt(x) == Math.pow(sum, 3);
    }

    private static boolean second(int x) {
        return x / 1000 + (x / 100) % 10 == (x % 100) / 10 + x % 10;
    }

    private static boolean third(int x) {
        int a = x / 100;
        int b = (x / 10) % 10;
        int c = x % 10;
        return a == b || a == c || b == c;
    }

    private static boolean fourth(double x) {
        double lastThree = (x * 1000) % 1000;
        for (int i = 0; i < 3; i++) {
            if (lastThree % 10 == 0) {
                return true;
            }
            lastThree /= 10;
        }
        return false;
    }
}
