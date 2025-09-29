package one.cycles;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Дано натуральное k. Напечатать k-ю цифру последовательности
 * 1123581321..., в которой выписаны подряд все числа Фибоначчи.
 */
public class TwentyThree {
    private static BigInteger a = BigInteger.ONE;
    private static BigInteger b = BigInteger.ONE;
    private static final List<BigInteger> fibNumbers = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int k = in.nextInt();
//            printAll(k);
//            System.out.println();
            System.out.println(findDigit(k));
        }
    }

    private static String findDigit(int k) {
        fibNumbers.add(a);
        double digitLength = 0;
        double totalDigitsSoFar = 0;
        double thisGroupDigitsCount;
        double prevTotalDigits;
        BigInteger upperBound;
        int prevGroupFibSize;

        do {
            digitLength++;
            upperBound = BigInteger.TEN.pow((int) digitLength).subtract(BigInteger.ONE);
            prevGroupFibSize = fibNumbers.size();
            getFibonacciInRange(upperBound);
            int thisGroupNumbersCount = fibNumbers.size() - prevGroupFibSize;
            thisGroupDigitsCount = thisGroupNumbersCount * digitLength;

            prevTotalDigits = totalDigitsSoFar;
            totalDigitsSoFar += thisGroupDigitsCount;
        } while (prevTotalDigits + thisGroupDigitsCount < k);

        /*
        используем prevTotalDigits -- то есть нижнюю границу группы
        и стартуем с индекса 0
         */
        double digitsNeeded = k - prevTotalDigits - 1;
        double numbersToSkipInGroup = digitsNeeded / digitLength;  // индекс внутри группы c 0
        int digitPosition = (int) (digitsNeeded % digitLength - 1); //учитываем, что индексируемся с 0

        return String.valueOf(fibNumbers.get((int) (prevGroupFibSize + numbersToSkipInGroup)).toString().charAt(digitPosition));
    }

    private static void getFibonacciInRange(BigInteger upperBound) {
        do {
            fibNumbers.add(b);
            b = a.add(b);
            a = b.subtract(a);
        } while (b.compareTo(upperBound) < 0);
    }

    //метод визуальной проверки
//    private static void printAll(int k) {
//        int i = 1;
//        int a = 1;
//        System.out.println(a + " " + i++);
//        int b = 1;
//        System.out.println(b + " " + i++);
//        for (; i <= k; i++) {//здесь i -- номер цифры
//            b = a + b; //в b лежит последнее число фибоначчи
//            a = b - a;
//            System.out.print(b + " ");
//            System.out.print(i + " ");
//            int copy = b;
//            while (copy >= 10) {
//                copy /= 10;
//                System.out.print(++i + " ");
//            }
//            System.out.println();
//        }
//    }
}
