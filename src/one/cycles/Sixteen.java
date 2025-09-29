package one.cycles;

import java.util.Scanner;

/**
 * Вычислить приближенно значение бесконечной суммы
 * (справа от каждой суммы дается ее точное значение, с которым можно сравнить полученный ответ):
 * 1/1 + 1/2^2 + 1/3^2 + ... = pi^2/6
 * 1/(1*3) + 1/(2*4) + 1/(3*5) + ... = 3/4
 * 1 + x^1/1! + x^2/2! + ... = e^x
 * Нужное приближение считается полученным, если вычислена сумма
 * нескольких первых слагаемых, и очередное слагаемое оказалось по
 * модулю меньше данного положительного числа D (точность).
 */
public class Sixteen {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter accuracy");
            double d = in.nextDouble();
            System.out.println(first(d));
            System.out.println(second(d));
            System.out.println("enter x");
            double x = in.nextDouble();
            System.out.println(third(d, x));
        }
    }

    //1/1^2 + 1/2^2 + 1/3^2 + ... = pi^1/6
    private static double first(double d) {
        double sum = 0.0;
        double term;
        int i = 1;
        do {
            term = 1.0 / i / i;//раскроем квадрат
            sum += term;
            i++;
        } while (Math.abs(term) >= d);
        System.out.println("exact solution " + Math.PI * Math.PI / 6);
        return sum;
    }

    //1/(1*3) + 1/(2*4) + 1/(3*5) + ... = 3/4
    //1/(i*(i+2)), i от 1
    private static double second(double d) {
        double sum = 0.0;
        double i = 1.0;
        double term;
        do {
            term = 1.0 / i / (i + 2);//раскроем дробь
            sum += term;
            i++;
        } while (Math.abs(term) >= d);
        System.out.println("exact solution " + 3.0 / 4.0);
        return sum;
    }

    //1 + x^1/1! + x^2/2! + ... = e^x
    //x(i) = x^i/i! = t(i-1) * x/i
    private static double third(double d, double x) {
        double sum = 0.0;
        double term = 1.0;//первое слагаемое
        int i = 0;

        while (Math.abs(term) >= d) {
            sum += term;
            i++;
            term = term * x / i;//следующее слагаемое из предыдущего
        }
        System.out.println("exact solution " + Math.pow(Math.E, x));
        return sum;
    }
}
