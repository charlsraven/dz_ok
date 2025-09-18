package one.cycles;

import java.util.Scanner;

/**
 * Пользователь вводит 1 число (A). Вывести все числа от 1 до 1000, которые делятся на A.
 */
public class Two {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();
            for (int i = 1; i <= 1000; i++) {
                if (i % a == 0) {
                    System.out.println(i);
                }
            }
        }
    }
}
