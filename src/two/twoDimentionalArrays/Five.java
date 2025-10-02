package two.twoDimentionalArrays;

import java.util.Scanner;

/**
 * Найти количество элементов массива, которые больше всех своих соседей одновременно
 */
public class Five {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter array size: n, m");
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] a = new int[n][m];
            System.out.println("enter array");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            int count = getCountSupremeNumbers(n, m, a);
            System.out.println(count);
        }
    }

    private static int getCountSupremeNumbers(int n, int m, int[][] a) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int flag = 0;
                flag += i > 0 ? a[i][j] > a[i - 1][j] ? 1 : 0 : 1;
                flag += i < n - 1 ? a[i][j] > a[i + 1][j] ? 1 : 0 : 1;
                flag += j > 0 ? a[i][j] > a[i][j - 1] ? 1 : 0 : 1;
                flag += j < m - 1 ? a[i][j] > a[i][j + 1] ? 1 : 0 : 1;
                if (flag == 4) {
                    count++;
                }
            }
        }
        return count;
    }
}
