package one.cycles;

import java.util.Scanner;

/**
 * Определить, является ли заданное число совершенным,
 * т.е. равным сумме всех своих (положительных) делителей, кроме самого этого числа
 * (например, число 6 совершенно: 6=1+2+3)
 */
public class Twenty {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int x = in.nextInt();
            System.out.println(perfect(x));
        }
    }

    private static boolean perfect(final int x) {
        if (x <= 1) {
            return false;
        }
        int sum = 1;//кроме самого этого числа -- поэтому сразу поделим на само число условно и запишем в значение суммы 1
        for (int i = 2; i * i <= x; i++) {//ну и раз получили делитель 1 до этого, то стартуем с 2
            if (x % i == 0) {
                sum += i;
                if (i != x / i) {
                    sum += x / i;
                }
            }
        }
        return sum == x;
    }
}
