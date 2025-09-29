package one.cycles;

import java.util.Scanner;

/**
 * Дано натуральное k. Напечатать k-ю цифру последовательности
 * 1234567891011121314..., в которой выписаны подряд все натуральные числа
 */
public class TwentyOne {
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

        do {
            digitLength++;
            /*
            для натуральных чисел легко заметна прогрессия:
            1 цифра * (10-1) чисел = 9 total цифр
            2 цифры * (100-10) чисел = 180 цифр в группе / 189 total
            3 цифры * (1000-100) чисел = 2700 total цифр / 2889 total
            numbersCount = 9 × 10^(digitLength-1)
            9*digitLength * 10^(digitLength-1)
             */
            thisGroupDigitCount = 9 * digitLength * Math.pow(10, digitLength - 1);
            prevTotalDigits = totalDigitsSoFar; //запоминаем прошлое значение
            totalDigitsSoFar += thisGroupDigitCount;
        } while (totalDigitsSoFar < k);

        double startNumber = Math.pow(10, digitLength - 1);
        /*
        используем prevTotalDigits -- то есть нижнюю границу группы
        и стартуем с индекса 0
         */
        double digitsNeeded = k - prevTotalDigits - 1;
        int numbersToSkip = (int) (digitsNeeded / digitLength);
        int digitPosition = (int) (digitsNeeded % digitLength);
        double targetNumber = startNumber + numbersToSkip;

        return Character.toString(Double.toString(targetNumber).charAt(digitPosition));
    }

    //метод визуальной проверки
//    private static void printAll(int k) {
//        int number = 0;
//        for (int i = 1; i <= k; i++) {
//            number++;
//            System.out.print(number + " ");
//            System.out.print(i + " ");
//            int copy = number;
//            while (copy >= 10) {
//                copy /= 10;
//                System.out.print(++i + " ");
//            }
//            System.out.println();
//        }
//    }
}
