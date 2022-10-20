package Semester_1.skuskove;

import java.math.BigInteger;
import java.util.Scanner;

public class Main495Fibonaci {
    private static BigInteger[] fibonacihoPostupnost = new BigInteger[5000 + 1];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        generujFibonacihoPostupnost();
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            System.out.printf("The Fibonacci number for %d is %s\n", input, fibonacihoPostupnost[input]);

        }
    }

    private static void generujFibonacihoPostupnost() {
        fibonacihoPostupnost[0] = BigInteger.valueOf(0);
        // System.out.println(fibonacihoPostupnost[0]);
        fibonacihoPostupnost[1] = BigInteger.valueOf(1);
        //System.out.println(fibonacihoPostupnost[1]);
        for (int n = 2; n <= fibonacihoPostupnost.length - 1; n++) {
            //fibonacihoPostupnost[n] = fibonacihoPostupnost[n - 1] + fibonacihoPostupnost[n - 2];
            fibonacihoPostupnost[n] = fibonacihoPostupnost[n - 1].add(fibonacihoPostupnost[n - 2]);
            //System.out.println(fibonacihoPostupnost[n]);
        }
    }
}