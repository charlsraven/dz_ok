package two.twoDimentionalArrays;

import java.util.Scanner;

/**
 * Заполнить двухмерный массив Т[1..n,1..n] последовательными целыми
 * числами от 1, расположенными по спирали, начиная с левого верхнего угла и
 * продвигаясь по часовой стрелке:
 */
public class Twelve {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter array size: n");
            int n = in.nextInt();
            print(fillSpiralDetailed(n));
        }
    }

    public static int[][] fillSpiralDetailed(int n) {
        int[][] a = new int[n][n];
        int i = 0;
        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = n - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // заполняем верхнюю строку слева направо
            for (int col = startCol; col <= endCol; col++) {
                a[startRow][col] = ++i;
            }
            startRow++; // отсекаем верхний предел

            // заполняем правый столбец сверху вниз
            for (int row = startRow; row <= endRow; row++) {
                a[row][endCol] = ++i;
            }
            endCol--; // отсекаем правый предел

            // заполняем нижнюю строку справа налево
            for (int col = endCol; col >= startCol; col--) {
                a[endRow][col] = ++i;
            }
            endRow--; // отсекаем нижний предел

            //заполняем левый столбец снизу вверх
            for (int row = endRow; row >= startRow; row--) {
                a[row][startCol] = ++i;
            }
            startCol++; // отсекаем левый предел
        }
        return a;
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
