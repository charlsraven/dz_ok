package two.oneDimentionalArrays;

import java.util.Scanner;

/**
 * Посчитать количество нечетных элементов массива
 */
public class Seven {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter array size");
            int n = in.nextInt();
            System.out.println("enter array");
            int[] array = new int[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
                if (array[i] % 2 != 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
