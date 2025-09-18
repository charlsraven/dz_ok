package one.branching;

import java.util.Scanner;

/**
 * Пользователь вводит 3 числа (A, B и С). Выведите в консоль решение(значения X) квадратного уравнения стандартного вида, где .
 */
public class Four {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            // ax^2 + bx + c = 0
            double d = b * b - 4 * a * c;
            if (d < 0) {
                System.out.println("no natural ans");
            } else {
                if (d == 0) {
                    System.out.println(-1 * b / (2 * a));
                } else {
                    System.out.println(-1 * b + Math.sqrt(d) / (2 * a));
                    System.out.println(-1 * b - Math.sqrt(d) / (2 * a));
                }
            }
        }
    }
}
