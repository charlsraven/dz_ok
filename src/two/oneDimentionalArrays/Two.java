package two.oneDimentionalArrays;

import java.util.Scanner;

/**
 * Найти максимальный элемент массива
 */
public class Two {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter array size");
            int n = in.nextInt();
            System.out.println("enter array");
            int[] array = new int[n];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
                if (array[i] > max) {
                    max = array[i];
                }
            }
            System.out.println(max);
        }
    }
}
