package Semester_1.doma_1;

import java.util.Scanner;
import java.util.TreeMap;

public class MainBinomalString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int pocetRiadkov = 100;
        int n = 0;
        long[][] faktorialy = new long[55][55];
        for (int i = 0; i < 55; i++) {
            for (int j = 0; j < i; j++) {
                if (i == 0 || j == 0) {
                    faktorialy[i][j] = 1;
                    continue;
                }
                faktorialy[i][j] = faktorialy[i - 1][j - 1] + faktorialy[i - 1][j];

            }
            //System.out.println();
        }

        int pocetRiadkov = scanner.nextInt();
        //while (n < pocetRiadkov) {
        while (scanner.hasNext()) {
            //String input;
            String znak = scanner.next();
            znak = znak.replace("(", "");
            znak = znak.replace(")", "");
            int znakPrvy = znak.indexOf("+");
            String prvyString = znak.substring(0, znakPrvy);
            int znakDruhy = znak.indexOf("^");
            String druhyString = znak.substring(znakPrvy + 1, znakDruhy);
            znak = znak.replace(prvyString, "");
            znak = znak.replace(druhyString,  "");
            znak = znak.replace("^",  "");
            int riadok = Integer.parseInt(znak);

//            System.out.println(prvyString);
//            System.out.println(druhyString);
//            System.out.println(riadok);
            TreeMap<Integer, String> a = new TreeMap<>();
            TreeMap<Integer, String> b = new TreeMap<>();

            for (int i = 0; i <= riadok; i++) {
                if (i == 0) {
                    a.put(i, "");
                } else if (i == 1) {
                    a.put(i, prvyString);
                } else {
                    a.put(i, String.format("%s^%d", prvyString, i));
                }
            }

            for (int i = 0; i <= riadok; i++) {
                if (i == 0) {
                    b.put(i, "");
                } else if (i == 1) {
                    b.put(i, druhyString);
                } else {
                    b.put(i, String.format("%s^%d", druhyString, i));
                }
            }

            System.out.printf("Case %d: ", n + 1);
            int poradiePrvehoZnaku = riadok;
            int poradieDruheZnaku = 0;
            for (int k = 0; k <= riadok; k++) {
                if (faktorialy[riadok + 1][k] == 1 ) {
                    System.out.printf("%s%s", a.get(poradiePrvehoZnaku), b.get(poradieDruheZnaku));
                    if (k < riadok) {
                        System.out.printf("+");
                    }
                    poradiePrvehoZnaku--;
                    poradieDruheZnaku++;
                    continue;
                }
                if (poradieDruheZnaku == 0 || poradiePrvehoZnaku == 0) {
                    System.out.format("+%d*%s%s", faktorialy[riadok + 1][k], a.get(poradiePrvehoZnaku), b.get(poradieDruheZnaku));
                    if (k < riadok) {
                        System.out.printf("+");
                    }
                }
                System.out.format("%d*%s*%s", faktorialy[riadok + 1][k], a.get(poradiePrvehoZnaku), b.get(poradieDruheZnaku));
                if (k < riadok) {
                    System.out.printf("+");
                }

                poradiePrvehoZnaku--;
                poradieDruheZnaku++;
            }
            System.out.println();
            n++;
        }

    }

}

