package Semester_1.Sutaz_2;

import java.util.Scanner;

public class MainSumOfAll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int suma = scanner.nextInt();
            int pocetScitancov = scanner.nextInt();
            if (suma == 0 && pocetScitancov == 0) {
                return;
            }
            int[] scitance = new int[pocetScitancov];
            for (int i = 0; i < pocetScitancov; i++) {
                scitance[i] = scanner.nextInt();
            }
            scanner.nextLine();

            System.out.printf("Sum of %d:\n", suma);
            boolean jeVypis = false;
            for (int i = 0; i < scitance.length; i++) {
                int[] pouziteScitance = new int[pocetScitancov];
                pouziteScitance[0] = scitance[i];
                if (generujSumy(i + 1, scitance, pouziteScitance, suma)) {
                    jeVypis = true;
                }
            }
//            int[] pouziteScitance = new int[pocetScitancov];
//            pouziteScitance[0] = scitance[0];
//            if (generujSumy(0, scitance, pouziteScitance, suma)) {
//                jeVypis = true;
//            }

            if (!jeVypis) {
                System.out.println("NONE");
            }
        }
    }

    private static boolean generujSumy(int poradie, int[] scitance, int[] pouziteScitance, int suma) {
        if (poradie >= scitance.length) {
//            for (int i = 0; i < pouziteScitance.length; i++) {
//                System.out.print(pouziteScitance[i]);
//                if (i < pouziteScitance.length) {
//                    System.out.print(" +");
//                }
//            }
//            System.out.println();
            return false;
        }
        int kontrolnaSuma = 0;
        for (int cislo : pouziteScitance) {
            kontrolnaSuma += cislo;
        }
        if (kontrolnaSuma  == suma) {
//            if (poradie + 1 < pouziteScitance.length) {
//                pouziteScitance[poradie + 1] = scitance[poradie];
//            }
            for (int i = 0; i < pouziteScitance.length; i++) {
                System.out.print(pouziteScitance[i]);
                if (i < pouziteScitance.length) {
                    System.out.print(" +");
                }
            }
            System.out.println();
            return true;

        }

        if (kontrolnaSuma + scitance[poradie] == suma) {
//            if (poradie + 1 < pouziteScitance.length) {
//                pouziteScitance[poradie + 1] = scitance[poradie];
//            }
            pouziteScitance[poradie] = scitance[poradie];
            for (int i = 0; i < pouziteScitance.length; i++) {
                System.out.print(pouziteScitance[i]);
                if (i < pouziteScitance.length) {
                    System.out.print(" +");
                }
            }
            System.out.println();
            return true;

        }

        if (kontrolnaSuma > suma) {
            return false;
        }
        if (kontrolnaSuma <= suma) {
            pouziteScitance[poradie] = scitance[poradie];
            if (generujSumy(poradie + 1, scitance, pouziteScitance, suma)) {
                return true;
            }

            pouziteScitance[poradie] = 0;
        }
        return false;
    }
}