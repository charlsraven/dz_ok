package one.cycles;

import java.util.Scanner;

/**
 * Пользователь вводит 2 числа. Найти их наибольший общий делитель используя алгоритм Евклида.
 */
public class Seven {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();
            int b = in.nextInt();
            //НОД(a, b) = НОД(b, a % b), пока b не станет равным нулю, a -- ответ
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            System.out.println(a);
        }
    }
}
