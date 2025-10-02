package two.oneDimentionalArrays;

import java.util.Scanner;

/**
 * Найти индекс максимального элемента массива
 */
public class Four {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter array size");
            int n = in.nextInt();
            System.out.println("enter array");
            int[] array = new int[n];
            int max = Integer.MIN_VALUE;
            int index = 0;
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
                if (array[i] > max) {
                    max = array[i];
                    index = i;
                }
            }
            System.out.println(index);
        }
    }
}
