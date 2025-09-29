package one.branching;

import java.util.Scanner;

/**
 * Определить, попадает ли точка M(x,y) в круг радиусом r с центром в точке (x0,y0)
 */
public class Six {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("enter x");
            int x = in.nextInt();
            System.out.println("enter y");
            int y = in.nextInt();
            System.out.println("enter r");
            int r = in.nextInt();
            System.out.println("enter x0");
            int x0 = in.nextInt();
            System.out.println("enter y0");
            int y0 = in.nextInt();
            if (Math.sqrt((x - x0) * (x - x0) + (y - y0) * (y - y0)) <= r) {
                System.out.println("in circle");
            } else {
                System.out.println("out of circle");
            }
        }
    }
}
