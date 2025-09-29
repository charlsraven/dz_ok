package one.cycles;

import java.util.Scanner;

/**
 * Дано действительное число х, натуральное число n. Вычислить:
 * 1/x + 1/(x(x+1)) + 1/(x(x+1)(x+2)) + ... + 1/(x(x+1)...(x+n))
 * x/1! + x^2/2! + ... + x^n/n!
 */
public class Fourteen {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            double x = in.nextDouble();
            int n = in.nextInt();
            System.out.println(first(x, n));
            System.out.println(second(x, n));
        }
    }

    //1/x + 1/x(x+1) + 1/x(x+1)(x+2) + ... + 1/x(x+1)...(x+n)
    //0     1          2                     n
    //рекуррентная формула будет t(i) = t(i-1)/(x+i)
    private static double first(double x, int n) {
        double sum = 0;
        double term = 1.0;
        for (int i = 0; i <= n; i++) {
            term /= x + i;
            sum += term;
        }
        return sum;
    }

    //x/1! + x^2/2! + ... + x^n/n!
    //рекуррентная формула t(i) = t(i-1)*x/i, где t(i-1)=x^(i-1)/(i-1)!
    private static double second(double x, int n) {
        double sum = 0;
        double term = 1.0;
        for (int i = 1; i <= n; i++) {
            term *= x / i;
            sum += term;
        }
        return sum;
    }
}