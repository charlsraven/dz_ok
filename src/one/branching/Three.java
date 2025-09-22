package one.branching;

import java.util.Scanner;

/**
 * Пользователь вводит 3 числа (A, B и С). Выведите их в консоль в порядке возрастания.
 */
public class Three {
    private static int x;
    private static int y;
    private static int z;

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            inc(a, b, c);
            System.out.println(x + " " + y + " " + z);
        }
    }

    private static void inc(int a, int b, int c) {
        if (a < b && a < c) {
            if (b < c) {
                x = a;
                y = b;
                z = c;
            } else {
                x = a;
                y = c;
                z = b;
            }
        } else if (b < a && b < c) {
            if (a < c) {
                x = b;
                y = a;
                z = c;
            } else {
                x = b;
                y = c;
                z = a;
            }
        } else {
            if (a < b) {
                x = c;
                y = a;
                z = b;
            } else {
                x = c;
                y = b;
                z = a;
            }
        }
    }
}
