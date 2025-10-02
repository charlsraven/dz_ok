package two.oneDimentionalArrays;

import java.util.Scanner;

/**
 * Найти минимальный элемент массива
 */
public class One {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter array size");
            int n = in.nextInt();
            System.out.println("enter array");
            int[] array = new int[n];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
                if (array[i] < min) {
                    min = array[i];
                }
            }
            System.out.println(min);
        }
    }
}
