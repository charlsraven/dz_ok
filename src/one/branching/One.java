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
            int ans;
            if (a > b) {
                ans = a + b;
            } else if (a == b) {
                ans = a * b;
            } else {
                ans = a - b;
            }
            System.out.println(ans);
        }
    }
}
