package one.branching;

import java.util.Scanner;

/**
 * Пользователь вводит 2 числа (X и Y). Определить какой четверти принадлежит точка с координатами (X,Y).
 */
public class Two {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (x == 0 || y == 0) {
                System.out.println("one of coordinates is zero");
            } else if (x > 0 && y > 0) {
                System.out.println("first");
            } else if (x < 0 && y > 0) {
                System.out.println("second");
            } else if (x < 0) {
                System.out.println("third");
            } else {
                System.out.println("fourth");
            }
        }
    }
}
