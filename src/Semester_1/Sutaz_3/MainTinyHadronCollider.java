package Semester_1.Sutaz_3;

import java.util.Scanner;

public class MainTinyHadronCollider {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTest = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfTest; i++) {
            int k = Integer.parseInt(scanner.nextLine());
            int[] cisla = new int[k];
            for (int j = 0; j < k; j++) {
                cisla[j] = Integer.parseInt(scanner.nextLine());
            }
            System.out.println(lcm(cisla));

        }
    }

    private static long lcm(int[] cisla) {
        long m = 1;
        for (int i = 0; i < cisla.length; i++) {
            m = lcm(m, cisla[i]);
        }
        return m;
    }

    private static long lcm(long A, long B) {
        return (A * B) / gcd(A, B);
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
