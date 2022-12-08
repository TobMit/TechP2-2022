package TechProg2.Sutaz3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long numberOfJars = scanner.nextLong();
        long sizeOfBox = scanner.nextLong();
        long vysledok = 0;
        if (numberOfJars != 0) {
            if (numberOfJars % sizeOfBox == 0) {
                System.out.println(sizeOfBox);
                return;
            }
            for (long i = 1; i <= sizeOfBox && i <= numberOfJars; i++) {
                if (numberOfJars % i == 0) {
                    vysledok = i;
                }
            }
        }
        //System.out.println(fermatFactorial(numberOfJars));
        System.out.println(vysledok);

    }

    private static long fermatFactorial(long number) {
        if (number % 2 == 0) {
            return 2;
        }
        if (prvocisla(number)) {
            return number;
        }
        long y = 0;
        while (isSquare(number + (y*y)) == false) {
            y += 1;
        }
        return (long) (Math.sqrt(number + (y*y)) - y);

    }

    private static boolean isSquare(long num) {
        long sr = (long)Math.sqrt(num);
        return (sr * sr) == num;
    }

    private static boolean prvocisla(long num) {

        if (num <= 3) {
            return num >= 2;
        }
        if ((num % 2 == 0) || (num % 3 == 0)) {
            return false;
        }
        //boolean ciklus = false;
        int div = 5;
        while (div * div <= num) {
            if ((num % div == 0) || (num % (div + 2)) == 0) {
                return false;
            }
            div += 6;
        }
        return true;
    }
}
