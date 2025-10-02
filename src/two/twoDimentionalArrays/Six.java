package two.twoDimentionalArrays;

import java.util.Scanner;

/**
 * Отразите массив относительно его главной диагонали
 */
public class Six {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter array size: n*n");
            int n = in.nextInt();
            int[][] a = new int[n][n];
            System.out.println("enter array");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            print(n, a);
            System.out.println();
            mirror(n, a);
            print(n, a);
        }
    }

    private static void mirror(int n, int[][] a) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = a[j][i];
                a[j][i] = a[i][j];
                a[i][j] = temp;
            }
        }
    }

    private static void print(int n, int[][] a) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
