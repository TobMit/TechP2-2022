package Semester_1.skuskove;

import java.util.Scanner;

public class Main11000 {
    public static void main(String[] args) {
        long[] male = new long[101];
        long[] female = new long[101];
        male[0] = 0;
        female[0] = 1;
        for (int i = 1; i < male.length; i++) {
            male[i] = male[i - 1] + female[i - 1];
            female[i] = male[i - 1] + 1;
        }

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            if (input == -1) {
                return;
            }
            if (input == 1) {
                System.out.printf("%d %d\n", male[input ], 2);
                continue;
            } else if (input == 0) {
                System.out.printf("%d %d\n", male[input], 1);
                continue;
            }
            System.out.printf("%d %d\n", male[input], male[input] + male[input - 1] + 1);

        }
    }
}