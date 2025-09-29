package one.cycles;

import java.util.Scanner;

/**
 * Дано натуральное k. Напечатать k-ю цифру последовательности
 * 149162536..., в которой выписаны подряд квадраты всех натуральных чисел.
 */
public class TwentyTwo {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int k = in.nextInt();
//            printAll(k);
//            System.out.println();
            System.out.println(findDigit(k));
        }
    }

    private static String findDigit(int k) {
        double digitLength = 0;
        double totalDigitsSoFar = 0;
        double thisGroupDigitCount;
        double prevTotalDigits;
        double minNumber;
        double maxNumber;

        do {
            digitLength++;
            //находим диапазон чисел, дающих квадраты заданной длины
            minNumber = Math.ceil(Math.pow(10, (digitLength - 1) / 2.0));
            maxNumber = Math.floor(Math.sqrt(Math.pow(10, digitLength) - 1));

            thisGroupDigitCount = (maxNumber - minNumber + 1) * digitLength;
            prevTotalDigits = totalDigitsSoFar;
            totalDigitsSoFar += thisGroupDigitCount;
        } while (totalDigitsSoFar < k);

        /*
        используем prevTotalDigits -- то есть нижнюю границу группы
        и стартуем с индекса 0
         */
        double digitsNeeded = k - prevTotalDigits - 1;
        int numbersToSkip = (int) (digitsNeeded / digitLength);
        int digitPosition = (int) (digitsNeeded % digitLength);
        double targetNumber = Math.pow(minNumber + numbersToSkip, 2);

        return Character.toString(Double.toString(targetNumber).charAt(digitPosition));
    }

    //метод визуальной проверки
//    private static void printAll(int k) {
//        int number = 0;
//        for (int i = 1; i <= k; i++) {
//            number++;
//            int square = number * number;
//            System.out.print(square + " ");
//            System.out.print(i + " ");
//            int copy = square;
//            while (copy >= 10) {
//                copy /= 10;
//                System.out.print(++i + " ");
//            }
//            System.out.println();
//        }
//    }
}
