package one.cycles;

import java.util.Scanner;

/**
 * Пользователь вводит 1 число (A). Вывести все числа от 1 до 1000, которые делятся на A.
 */
public class Two {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();
            del(a);
        }
    }

    private static void del(int a) {
        if (a <= 0 || a > 1000) {
            System.out.println("неверные входные данные");
            return;
        }
        for (int i = a; i <= 1000; i += a) {
            System.out.println(i);
        }
    }
}
