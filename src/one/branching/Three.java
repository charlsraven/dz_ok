package one.branching;

import java.util.Scanner;

/**
 * Пользователь вводит 3 числа (A, B и С). Выведите их в консоль в порядке возрастания.
 */
public class Three {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            if (a < b && a < c) {
                if (b < c) {
                    System.out.println(a + " " + b + " " + c);
                } else {
                    System.out.println(a + " " + c + " " + b);
                }
            } else if (b < a && b < c) {
                if (a < c) {
                    System.out.println(b + " " + a + " " + c);
                } else {
                    System.out.println(b + " " + c + " " + a);
                }
            } else {
                if (a < b) {
                    System.out.println(c + " " + a + " " + b);
                } else {
                    System.out.println(c + " " + b + " " + a);
                }
            }
        }
    }
}
