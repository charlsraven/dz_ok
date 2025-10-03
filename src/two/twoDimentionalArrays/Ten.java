package two.twoDimentionalArrays;

import java.util.Scanner;

/**
 * Массив А[1..N,1..M] содержит вещественные числа.
 * Требуется ввести целое число K и вычислить сумму элементов А[I,J], для которых I+J=К
 * Прежде, однако следует убедиться, что значение К позволяет найти решение,
 * в противном случае нужно напечатать сообщение об ошибке.
 */
public class Ten {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter array size: n, m");
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] a = new int[n + 1][m + 1];
            System.out.println("enter array");
            for (int i = 1; i < a.length; i++) {
                for (int j = 1; j < a[i].length; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            System.out.println("enter k");
            int k = in.nextInt();
            if (k < 2 || k > n + m) {
                System.out.println("k is out of array boundaries");
            } else {
                print(a);
                System.out.println("sum of k elements: " + sumK(a, k));
            }
        }
    }

    private static int sumK(int[][] a, int k) {
        int sum = 0;
        for (int i = 1; i < a.length; i++) {
            sum += a[i][k - i];
        }
        return sum;
    }


    private static void print(int[][] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}

