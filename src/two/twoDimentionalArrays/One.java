package two.twoDimentionalArrays;

import java.util.Scanner;

/**
 * Найти минимальный элемент массива
 */
public class One {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter array size: n, m");
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] array = new int[n][m];
            System.out.println("enter array");
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    array[i][j] = in.nextInt();
                    if (array[i][j] < min) {
                        min = array[i][j];
                    }
                }
            }
            System.out.println(min);
        }
    }
}
