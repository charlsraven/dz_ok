package one.cycles;

import java.util.Scanner;

/**
 * Пользователь вводит 1 число (A). Найдите количество положительных целых чисел, квадрат которых меньше A.
 */
public class Three {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();
            System.out.println((int) Math.sqrt(a) - 1);
        }
    }
}
