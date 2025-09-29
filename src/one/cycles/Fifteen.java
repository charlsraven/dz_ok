package one.cycles;

import java.util.Scanner;

/**
 * Дано натуральное n. Вычиcлить
 * П(2 + 1/i!)
 * S(1+i)/i!
 * для i от 1 до n
 */
public class Fifteen {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            System.out.println(first(n));
            System.out.println(second(n));
        }
    }

    //П(2 + 1/i!)
    //рекуррентная формула факториала i! = (i-1)! * i, то есть запоминаем предыдущее значение и домнажаем на i
    private static double first(int n) {
        double res = 1.0;
        double factorial = 1.0;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            res *= 2.0 + 1.0 / factorial;
        }
        return res;
    }

    //S(1+i)/i!
    //рекуррентная формула факториала i! = (i-1)! * i, то есть запоминаем предыдущее значение и домнажаем на i
    private static double second(int n) {
        double res = 0.0;
        double factorial = 1.0;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            res += (1.0 + i) / factorial;
        }
        return res;
    }
}
