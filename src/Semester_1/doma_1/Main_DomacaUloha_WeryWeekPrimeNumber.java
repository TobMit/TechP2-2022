package Semester_1.doma_1;

import java.util.Scanner;

public class Main_DomacaUloha_WeryWeekPrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] prvocisla = new int[78498];
        int sucet = 0;
        for (int i = 0; i <= 1000000; i++) {
            if (Main_DomacaUloha_WeryWeekPrimeNumber.prvocisla(i)) {
                prvocisla[sucet] = i;
                sucet++;
            }
        }

        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            if (input == 0) {
                return;
            }
            int sucetPrvocisel = 0;
            int medzivysledok = input;
            int odlozenePrvocislo = 0;

            for (int i = 0; i < prvocisla.length; i++) {
                if (medzivysledok == 1) {
                    break;
                }
                while (medzivysledok % prvocisla[i] == 0) {
                    medzivysledok = medzivysledok / prvocisla[i];
                    //System.out.println(prvocisla[i] + " x ");

                    if (odlozenePrvocislo != prvocisla[i]) {
                        sucetPrvocisel++;
                        odlozenePrvocislo = prvocisla[i];
                    }
                }
            }
            //System.out.println("\n" + sucetPrvocisel + "\n");
            if (prvocisla(sucetPrvocisel)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean prvocisla(int num) {

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