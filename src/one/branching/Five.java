package one.branching;

import java.util.Scanner;

public class Five {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int x = in.nextInt();
            int tens = x / 10;
            int ones = x % 10;
            StringBuilder str = new StringBuilder();
            if (tens == 1) {
                switch (ones) {
                    case 0 -> str.append("десять");
                    case 1 -> str.append("одиннадцать");
                    case 2 -> str.append("двенадцать");
                    case 3 -> str.append("тринадцать");
                    case 4 -> str.append("четырнадцать");
                    case 5 -> str.append("пятнадцать");
                    case 6 -> str.append("шестнадцать");
                    case 7 -> str.append("семнадцать");
                    case 8 -> str.append("восемнадцать");
                    case 9 -> str.append("девятнадцать");
                }
            } else {
                switch (tens) {
                    case 2 -> str.append("двадцать");
                    case 3 -> str.append("тридцать");
                    case 4 -> str.append("сорок");
                    case 5 -> str.append("пятьдесят");
                    case 6 -> str.append("шестьдесят");
                    case 7 -> str.append("семьдесят");
                    case 8 -> str.append("восемьдесят");
                    case 9 -> str.append("девяносто");
                }
                switch (ones) {
                    case 1 -> str.append(" один");
                    case 2 -> str.append(" два");
                    case 3 -> str.append(" три");
                    case 4 -> str.append(" четыре");
                    case 5 -> str.append(" пять");
                    case 6 -> str.append(" шесть");
                    case 7 -> str.append(" семь");
                    case 8 -> str.append(" восемь");
                    case 9 -> str.append(" девять");
                }
            }
            System.out.println(str);
        }
    }
}
