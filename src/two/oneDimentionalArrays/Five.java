package two.oneDimentionalArrays;

import java.util.Scanner;

/**
 * Посчитать сумму элементов массива с нечетными индексами
 */
public class Five {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter array size");
            int n = in.nextInt();
            System.out.println("enter array");
            int[] array = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
                if (i % 2 != 0) {
                    sum += array[i];
                }
            }
            System.out.println(sum);
        }
    }
}
