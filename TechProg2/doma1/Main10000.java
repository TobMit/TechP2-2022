package TechProg2.doma1;

import java.util.Scanner;

public class Main10000 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) {
        int numberOfPoints = scanner.nextInt();
        if (numberOfPoints == 0) {
            return;
        }
        int startingPoint = scanner.nextInt();
        boolean loop = true;

        while (loop) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            if (first == 0 && second == 0) {
                loop = false;
            }
        }
    }
}
