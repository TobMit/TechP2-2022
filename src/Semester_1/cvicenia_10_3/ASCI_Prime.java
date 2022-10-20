package Semester_1.cvicenia_10_3;

import java.util.Scanner;

public class ASCI_Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //scanner.useDelimiter("");
        int sumCislo = 0;
        while (scanner.hasNext()) {
            String input = scanner.next();


            char[] znak = input.toCharArray();
            for (char znaky: znak) {
                int cislo = znaky;
                if (cislo == 10) {
                    continue;
                }
                if (cislo >= 97) {
                    cislo -= 96;
                }
                if (cislo >= 65) {
                    cislo -= 64 - 26;
                }
                sumCislo += cislo;
            }

            //System.out.println(sumCislo);






            if (ASCI_Prime.overenie(sumCislo)) {
                System.out.println("It is a prime word.");
            } else {
                System.out.println("It is not a prime word.");
            }

//            for (int i = 0; i < 10000; i++) {
//                if (MainPrimeWords.overenie(i)) {
//                    System.out.println(i);
//                }
//            }

            sumCislo = 0;

        }

    }

    private static boolean overenie(int num) {
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
