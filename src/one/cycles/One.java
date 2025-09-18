package one.cycles;

import java.util.Scanner;

/**
 * Пользователь вводит 2 числа (A и B). Возвести число A в степень B.
 */
public class One {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            final int a = in.nextInt();
            final int b = in.nextInt();
            int ans = 1;
            for (int i = 0; i < b; i++) {
                ans *= a;
            }
            System.out.println(ans);
        }
    }
}
