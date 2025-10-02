package two.twoDimentionalArrays;

import java.util.Scanner;

/**
 * Найти максимальный элемент массива
 */
public class Two {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter array size: n, m");
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] array = new int[n][m];
            System.out.println("enter array");
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    array[i][j] = in.nextInt();
                    if (array[i][j] > max) {
                        max = array[i][j];
                    }
                }
            }
            System.out.println(max);
        }
    }
}
