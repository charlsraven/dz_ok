package one.branching;

import java.util.Scanner;

/**
 * Пользователь вводит 3 числа (A, B и С). Выведите в консоль решение(значения X) квадратного уравнения стандартного вида, где
 * ax^2 + bx + c = 0
 */
public class Four {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            double d = b * b - 4 * a * c;
            StringBuilder ans = new StringBuilder();
            if (d < 0) {
                ans.append("no natural ans");
            } else {
                if (d == 0) {
                    ans.append((-1 * b) / (2 * a));
                } else {
                    ans.append(-1 * b + Math.sqrt(d) / (2 * a));
                    ans.append("/n");
                    ans.append(-1 * b - Math.sqrt(d) / (2 * a));
                }
            }
            System.out.println(ans);
        }
    }
}
