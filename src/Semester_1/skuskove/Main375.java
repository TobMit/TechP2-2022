package Semester_1.skuskove;

import java.util.Scanner;
import java.util.StringTokenizer;


public class Main375 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noTest = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < noTest ; i++) {
            scanner.nextLine();

            StringTokenizer parser = new StringTokenizer(scanner.nextLine(), " ");
            double B = Double.parseDouble(parser.nextToken());
            double H = Double.parseDouble(parser.nextToken());
            double area = B * H / 2;

            double cislo1 = Math.sqrt(H * H + B * B / 4) * 2 + B;
            double cislo2 = area * 2 / cislo1;

            double C = 0;
            while (cislo2 >= 0.000001) {
                C += 2 * Math.PI * cislo2;

                double odlCislo = H;

                H -= 2 * cislo2;
                cislo2 *= H / odlCislo;
            }

            System.out.printf("%13.6f\n", C);
            if (i != noTest - 1) {
                System.out.println("");
            }
        }

    }
}

