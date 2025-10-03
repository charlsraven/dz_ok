package two.twoDimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дан двухмерный массив A[1..m,1..n].
 * Написать программу построения одномерного массива B[1..m],
 * элементы которого соответственно равны
 * а) суммам элементов строк,
 * б) произведениям элементов строк,
 * в) наименьшим средних арифметических элементов строк.
 */
public class Eight {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter array size: m, n");
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] a = new int[m][n];
            System.out.println("enter array");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            print(a);
            System.out.println("row sums");
            System.out.println(Arrays.toString(rowSums(a)));
            System.out.println("row multiplications");
            System.out.println(Arrays.toString(rowMultiplications(a)));
            System.out.println("min Arithmetic Mean doesn't exist");
            System.out.println(Arrays.toString(minArithmeticMean(a)));
        }
    }


    //суммам элементов строк
    private static int[] rowSums(int[][] a) {
        int[] sums = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = 0; j < a[i].length; j++) {
                sum += a[i][j];
            }
            sums[i] = sum;
        }
        return sums;
    }

    //произведениям элементов строк
    private static int[] rowMultiplications(int[][] a) {
        int[] multiplications = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int multiplication = 1;
            for (int j = 0; j < a[i].length; j++) {
                multiplication *= a[i][j];
            }
            multiplications[i] = multiplication;
        }
        return multiplications;
    }

    //наименьшим средних арифметических элементов строк -- некорректная формулировка
    private static int[] minArithmeticMean(int[][] a) {
        return null;
    }

    private static void print(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
