package one.branching;

import java.util.Scanner;


/**
 * Пользователь вводит 2 числа (A и B). Если A>B, подсчитать A+B, если A=B, подсчитать A*B, если A<B, подсчитать A-B.
 */
public class One {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a > b) {
                System.out.println(a + b);
            } else if (a == b) {
                System.out.println(a * b);
            } else {
                System.out.println(a - b);
            }
        }
    }
}
