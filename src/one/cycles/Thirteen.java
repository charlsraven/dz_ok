package one.cycles;

import java.util.Scanner;

/**
 * Дано натуральное n. Вычислить
 * (1 + 1/1^2) + (1 + 1/2^2) + ... + (1 + 1/n^2)
 */
public class Thirteen {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            //упростим функцию, разнеся знак суммы на оба слагаемых в скобках
            //тогда получим n + sum(1/n^2)
            //второе слагаемое -- Basel problem, её решаем в лоб
            int n = in.nextInt();
            double sum = n;
            for (int i = 0; i < n; i++) {
                sum += 1.0 / (n * n);
            }
            System.out.println(sum);
        }
    }
}
