package two.twoDimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дана матрица NxM.
 * Переставляя ее строки и столбцы, переместить наибольший элемент в верхний левый угол.
 * Определить можно ли таким же образом поместить минимальный элемент в нижний правый угол.
 */
public class Eleven {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter array size: n, m");
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] a = new int[n][m];
            System.out.println("enter array");
            Point max = new Point(0, 0, Integer.MIN_VALUE);
            Point min = new Point(0, 0, Integer.MAX_VALUE);
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] = in.nextInt();
                    if (a[i][j] > max.getValue()) {
                        max = new Point(i, j, a[i][j]);
                    }
                    if (a[i][j] < min.getValue()) {
                        min = new Point(i, j, a[i][j]);
                    }
                }
            }

            System.out.println("move the max");
            print(a);
            moveMax(deepCopy(a), max);

            System.out.println("move the min");
            print(a);
            moveMin(deepCopy(a), min);
        }
    }

    private static void moveMax(int[][] a, Point max) {
        int finalX = 0;
        int finalY = 0;
        while (max.getX() != finalX) {
            int x = max.getX();
            var temp = a[x - 1];
            a[x - 1] = a[x];
            a[x] = temp;
            max.setX(--x);
            print(a);
        }
        while (max.getY() != finalY) {
            int y = max.getY();
            for (int i = 0; i < a.length; i++) {
                int temp = a[i][y - 1];
                a[i][y - 1] = a[i][y];
                a[i][y] = temp;
            }
            max.setY(--y);
            print(a);
        }
    }

    private static void moveMin(int[][] a, Point min) {
        int finalX = a.length - 1;
        int finalY = a[0].length - 1;
        while (min.getX() != finalX) {
            int x = min.getX();
            var temp = a[x + 1];
            a[x + 1] = a[x];
            a[x] = temp;
            print(a);
            min.setX(++x);
        }
        while (min.getY() != finalY) {
            int y = min.getY();
            for (int i = 0; i < a.length; i++) {
                int temp = a[i][y + 1];
                a[i][y + 1] = a[i][y];
                a[i][y] = temp;
            }
            min.setY(++y);
            print(a);
        }
    }

    private static int[][] deepCopy(int[][] original) {
        return Arrays.stream(original)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    private static void print(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("---");
    }

    static class Point {
        private int x;
        private int y;
        private final int value;

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getValue() {
            return value;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}