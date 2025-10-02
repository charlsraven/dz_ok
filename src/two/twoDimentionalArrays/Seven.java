package two.twoDimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дана вещественная матрица размерности n * m.
 * По матрице получить логический вектор,
 * присвоив его k-ому элементу значение True, если выполнено указанное условие и значение False иначе:
 * - все элементы k столбца нулевые;
 * - элементы k строки матрицы упорядочены по убыванию;
 * - k строка массива симметрична.
 */
public class Seven {

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
            print(a);
            boolean[] zeroColumns = getZeroColumnsVector(a);
            System.out.println("all elements of column k are zeros");
            System.out.println(Arrays.toString(zeroColumns));
            boolean[] descendingRows = getDescendingRowsVector(a);
            System.out.println("elements of row k are descending");
            System.out.println(Arrays.toString(descendingRows));
            boolean[] symmetricRows = getSymmetricRowsVector(a);
            System.out.println("row k is symmetric");
            System.out.println(Arrays.toString(symmetricRows));
        }
    }

    //все элементы k столбца нулевые
    public static boolean[] getZeroColumnsVector(int[][] a) {
        boolean[] result = new boolean[a[0].length];
        for (int k = 0; k < a[0].length; k++) {
            boolean allZero = true;
            for (int[] ints : a) {
                if (ints[k] != 0) {
                    allZero = false;
                    break;
                }
            }
            result[k] = allZero;
        }
        return result;
    }

    //элементы k строки матрицы упорядочены по убыванию
    public static boolean[] getDescendingRowsVector(int[][] a) {
        boolean[] result = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            boolean isDescending = true;
            for (int j = 0; j < a[i].length - 1; j++) {
                if (a[i][j] < a[i][j + 1]) {
                    isDescending = false;
                    break;
                }
            }
            result[i] = isDescending;
        }
        return result;
    }

    //k строка массива симметрична
    public static boolean[] getSymmetricRowsVector(int[][] a) {
        boolean[] result = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            boolean isSymmetric = true;
            int m = a[i].length;
            for (int j = 0; j < m / 2; j++) {
                if (a[i][j] != a[i][m - j - 1]) {
                    isSymmetric = false;
                    break;
                }
            }
            result[i] = isSymmetric;
        }
        return result;
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
