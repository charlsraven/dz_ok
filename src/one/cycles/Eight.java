package one.cycles;

import java.util.Scanner;

/**
 * Пользователь вводит целое положительное число, которое является кубом целого числа N.
 * Найдите число N методом половинного деления.
 */
public class Eight {
    private final static double epsilon = 0.000001; // Точность

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println(findCubicRoot(in.nextInt()));
        }
    }

    private static double findCubicRoot(int x) {
        double low = 0, high = x;
        while (high - low > epsilon) {
            double mid = (low + high) / 2;
            if (mid * mid * mid > x) {
                high = mid;
            }
            if (mid * mid * mid <= x) {
                low = mid;
            }
        }
        return (low + high) / 2;
    }
}
/*
метод половинного деления — это алгоритм поиска корня уравнения на заданном интервале [a, b],
на котором функция меняет знак (т.е. гарантированно существует корень).
нужно последовательно делить интервал пополам и выбирать ту половину,
на которой функция всё ещё меняет знак, сужая диапазон до тех пор, пока он не станет меньше требуемой точности epsilon.

решаем уравнение x³ - n = 0
определяем интервал [low, high]: low = 0, high = n (достаточно, потому что есть вводные, что n>=1)
f(mid) = mid^3 - n, где mid = (low + high) / 2 ->
определяем новый интервал:
если f(mid) == 0 (или очень близко к нулю), то mid — корень
если f(mid) * f(low) < 0, корень лежит в левой половине (high = mid)
иначе корень в правой половине (low = mid)
повторяем, пока |high - low| не станет меньше заданной точности epsilon
 */