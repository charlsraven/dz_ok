package one.cycles;

/**
 * Найти все двузначные числа, сумма цифр которых не меняется при
 * умножении числа на 2,3,4,5,6,7,8,9.
 */
public class Seventeen {
    /*
    simple решение:
    System.out.println(18);
    */
    public static void main(String[] args) {
        /*
        k*(10A + B) - (10A + B) = (k-1)*(10A + B) -> сумма цифр должна делиться на 9
        Если число делится на 9, то и сумма его цифр делится на 9.
        Если сумма цифр сохраняется при умножении, то результат умножения тоже должен делиться на 9.

        Исходное условие: S(X) = S(kX) (суммы цифр равны)
        Известный факт: X <-> S(X) (mod 9) -- число и сумма его цифр дают одинаковый остаток при делении на 9
        kX <-> S(kX) (mod 9)
        S(X) = S(kX) по условию -> X <-> kX (mod 9)
        Переносим: kX - X <-> 0 (mod 9) -> (k-1)X <-> 0 (mod 9)
        */
        for (int num = 18; num <= 99; num += 9) {
            int originalSum = digitSum(num);
            boolean valid = true;
            for (int i = 2; i <= 9; i++) {
                if (digitSum(num * i) != originalSum) {
                    valid = false;
                    //если при умножении на k сумма уже разная, дальше не проверяем
                    break;
                }
            }

            if (valid) {
                System.out.println(num);
            }
        }
    }

    public static int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}