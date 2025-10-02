package two.oneDimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Поменять местами первую и вторую половину массива, например, для
 * массива 1 2 3 4, результат 3 4 1 2, или для 12345 - 45312.
 */
public class Eight {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter array size");
            int n = in.nextInt();
            System.out.println("enter array");
            int[] reversed = new int[n];
            for (int i = (int) Math.ceil(n / 2.0); i < n; i++) {
                reversed[i] = in.nextInt();
            }
            if (n % 2 != 0) {
                reversed[(int) Math.floor(n / 2.0)] = in.nextInt();
            }
            for (int i = 0; i < (int) Math.floor(n / 2.0); i++) {
                reversed[i] = in.nextInt();
            }

            System.out.println(Arrays.toString(reversed));
        }
    }
}
