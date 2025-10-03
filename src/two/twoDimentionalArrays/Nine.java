package two.twoDimentionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * В массиве А[1..N,1..N] определить номера строки и столбца какой-нибудь седловой точки.
 * Некоторый элемент массива называется седловой точкой,
 * если он является одновременно наименьшим в своей строке
 * и наибольшим в своем столбце.
 */
public class Nine {
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
            print(a);
            System.out.println("coordinates of saddle point: " + saddlePoint(a));
        }
    }

    private static Point saddlePoint(int[][] a) {
        List<Point> mins = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int min = a[i][0];
            for (int j = 1; j < a.length; j++) {
                if (a[i][j] < min) {
                    min = a[i][j];
                }
            }
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == min) {
                    mins.add(new Point(i, j));
                }
            }
        }
        List<Point> maxs = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int max = a[0][i];
            for (int j = 1; j < a.length; j++) {
                if (a[j][i] > max) {
                    max = a[j][i];
                }
            }
            for (int j = 0; j < a.length; j++) {
                if (a[j][i] == max) {
                    maxs.add(new Point(j, i));
                }
            }
        }
        maxs.retainAll(mins);
        if (maxs.isEmpty()) {
            return null;
        }
        return maxs.get(0);
    }


    private static void print(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public record Point(int x, int y) {
        @Override
        public String toString() {
            return String.format("[%d,%d]", x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point point)) return false;
            return x() == point.x() && y() == point.y();
        }

        @Override
        public int hashCode() {
            return Objects.hash(x(), y());
        }
    }
}

