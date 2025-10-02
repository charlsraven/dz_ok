package two.oneDimentionalArrays;

import java.util.Scanner;

/**
 * Найти индекс минимального элемента массива
 */
public class Three {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter array size");
            int n = in.nextInt();
            System.out.println("enter array");
            int[] array = new int[n];
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
                if (array[i] < min) {
                    min = array[i];
                    index = i;
                }
            }
            System.out.println(index);
        }
    }
}
