package one.cycles;

import java.util.Scanner;

/**
 * Пользователь вводит 1 число (A). Вывести наибольший делитель (кроме самого A) числа A.
 */
public class Four {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int a = in.nextInt();
            int nd = a;
            for (int i = a / 2; i >= 1; i--) {
                if (a % i == 0) {
                    nd = i;
                    break;
                }
            }
            System.out.println(nd == a ? "число а простое" : nd);
        }
    }
}
