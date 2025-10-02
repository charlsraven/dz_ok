package two.oneDimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Отсортировать массив по возрастанию одним из способов:
 * пузырьком(Bubble) или вставками (Insert)
 */
public class Nine {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter sorting type: bubble or insert");
            String type = in.nextLine();
            System.out.println("enter array size");
            int n = in.nextInt();
            System.out.println("enter array");
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            if (type.equals("bubble")) {
                System.out.println(Arrays.toString(bubble(array)));
            } else {
                System.out.println(Arrays.toString(insert(array)));
            }
        }
    }

    private static int[] insert(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j > 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        return array;
    }

    private static int[] bubble(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swapped = true;
                    int t = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = t;
                }
            }
            if (!swapped) break;
        }
        return array;
    }

}
