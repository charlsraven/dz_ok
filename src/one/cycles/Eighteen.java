package one.cycles;

/**
 * Найти все трехзначные числа, представимые в виде сумм факториалов своих цифр
 */
public class Eighteen {

    /*
    simple решение:
    System.out.println(145);
    */
    public static void main(String[] args) {
        /*
        0!=1,1!=1,2!=2,3!=6,4!=24,5!=120,6!=720,7!=5040,8!=40320,9!=362880
        -> все цифры числа должны быть <=6
        -> если есть цифра 6, то остальные <= 5
        тогда максимальное возьмём за 655, а минимальное за 105
         */
        int[] factorials = new int[]{1, 1, 2, 6, 24, 120, 720}; //факториалы цифр 0..6
        int sum;
        for (int i = 105; i <= 655; i++) {
            sum = factorials[i / 100] + factorials[(i / 10) % 10] + factorials[i % 10];
            if (i == sum) {
                System.out.println(i);
            }
        }
    }
}
