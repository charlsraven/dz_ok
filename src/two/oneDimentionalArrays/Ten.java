package two.oneDimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Отсортировать массив по убыванию одним из способов:
 * быстрая сортировка,
 * Timsort,
 * сортировка слиянием,
 * сортировка кучей
 */
public class Ten {
    static int MIN_MERGE = 64;

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter sorting type: quick, timsort, merge, heap");
            String type = in.nextLine();
            System.out.println("enter array size");
            int n = in.nextInt();
            System.out.println("enter array");
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            switch (type) {
                case "quick" -> System.out.println(Arrays.toString(quick(array)));
                case "merge" -> System.out.println(Arrays.toString(merge(array)));
                case "timsort" -> System.out.println(Arrays.toString(tim(array)));
                default -> System.out.println(Arrays.toString(heap(array)));
            }
        }
    }

    private static int[] quick(int[] a) {
        quickSort(a, 0, a.length - 1);
        return a;
    }

    private static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int q = partition(a, l, r);
            quickSort(a, l, q);
            quickSort(a, q + 1, r);
        }
    }

    private static int partition(int[] a, int l, int r) {
        int v = a[(l + r) / 2];
        int i = l;
        int j = r;
        while (i <= j) {
            while (a[i] > v) {
                i++;
            }
            while (a[j] < v) {
                j--;
            }
            if (i >= j) {
                break;
            }
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return j;
    }

    private static int[] merge(int[] a) {
        mergeSort(a, 0, a.length);
        return a;
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left + 1 >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(a, left, mid);
        mergeSort(a, mid, right);
        merging(a, left, mid, right);
    }

    private static void merging(int[] a, int left, int mid, int right) {
        int it1 = 0;
        int it2 = 0;
        int[] result = new int[right - left];

        while (left + it1 < mid && mid + it2 < right) {
            if (a[left + it1] > a[mid + it2]) {
                result[it1 + it2] = a[left + it1];
                it1 += 1;
            } else {
                result[it1 + it2] = a[mid + it2];
                it2 += 1;
            }
        }
        while (left + it1 < mid) {
            result[it1 + it2] = a[left + it1];
            it1 += 1;
        }
        while (mid + it2 < right) {
            result[it1 + it2] = a[mid + it2];
            it2 += 1;
        }
        if (it1 + it2 >= 0) {
            System.arraycopy(result, 0, a, left, it1 + it2);
        }
    }

    private static int[] tim(int[] a) {
        timsort(a);
        return a;
    }

    private static void timsort(int[] a) {
        int n = a.length;
        //run -- подмассив во входном массиве, упорядоченный либо строго по убыванию, либо нестрого по возрастанию
        int minRun = minRunLength(n);

        /* сортируем любой устойчивой сортировкой подмассивы размена run
         на самом деле для маленьких массивов более подходящей будет сортировка вставками
         но будем использовать устойчивую сортировку из этого класса -- сортировку слияниями
         */
        for (int i = 0; i < n; i += minRun) {
            mergeSort(a, i, Math.min(i + minRun, n));
        }

        // мёрджим по степеням двойки
        for (int size = minRun; size < n; size = 2 * size) {
            /*
            выбираем стартовую точку в левом подмассиве
            мёрджим arr[left..left+size-1] и arr[left+size, left+2*size-1]
            после каждого мерджа увеличиваем левую границу в 2 раза
             */
            for (int left = 0; left < n; left += 2 * size) {
                /*
                находим конечную точку левого подмассива
                mid+1 -- стартовая точка правого подмассива
                 */
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                // мерджим arr[left.....mid] и arr[mid+1....right]
                if (mid < right) {
                    mergeSortedRuns(a, left, mid, right);
                }
            }
        }
    }

    private static int minRunLength(int n) {
        int flag = 0;// будет равно 1, если среди сдвинутых битов есть хотя бы один ненулевой
        while (n >= MIN_MERGE) {
            flag |= n & 1;
            n >>= 1;
        }
        return n + flag;
    }

    public static void mergeSortedRuns(int[] arr, int l, int m, int r) {
        int len1 = m - l + 1;
        int len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        System.arraycopy(arr, l, left, 0, len1);
        System.arraycopy(arr, m + 1, right, 0, len2);

        int i = 0;
        int j = 0;
        int k = l;

        // сравниваем и сливаем 2 массива в больший подмассив
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        //копируем остатки от левого
        while (i < len1) {
            arr[k] = left[i];
            k++;
            i++;
        }
        //копируем остатки от правого
        while (j < len2) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    private static int[] heap(int[] a) {
        int n = a.length;

        // строим кучу
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        // извлекаем элементы из кучи
        for (int i = n - 1; i > 0; i--) {
            // перемещаем текущий корень в конец
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            // преобразуем в двоичную кучу поддерево
            heapify(a, i, 0);
        }
        return a;
    }


    //преобразовываем в двоичную кучу поддерево с корневым узлом i
    private static void heapify(int[] a, int n, int i) {
        int root = i; // наименьший элемент -- корень
        int l = 2 * i + 1; // левый
        int r = 2 * i + 2; // правый

        // проверяем левый дочерний элемент
        if (l < n && a[l] < a[root]) {
            root = l;
        }
        // проверяем правый дочерний элемент
        if (r < n && a[r] < a[root]) {
            root = r;
        }
        // если самый маленький элемент не корень
        if (root != i) {
            int temp = a[i];
            a[i] = a[root];
            a[root] = temp;

            // преобразуем в двоичную кучу затронутое поддерево
            heapify(a, n, root);
        }
    }

}
