package two.oneDimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Сделать реверс массива (массив в обратном направлении)
 */
public class Six {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter array size");
            int n = in.nextInt();
            System.out.println("enter array");
            int[] reversed = new int[n];
            for (int i = 0; i < n; i++) {
                reversed[n - 1 - i] = in.nextInt();
            }
            System.out.println(Arrays.toString(reversed));
        }
    }
}
