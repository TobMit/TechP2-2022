import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main602WhatDayIsIt {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final String[] nameOfMonths= {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    // 1.1.0001 bola sobota tak je to posunuté
    private static final String[] nameOfDays = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private static final int[][] daysInMoths = { {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                                                 {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} };
    private static final int yearOfSwitch = 1752;
    public static void main(String[] args) throws IOException {
        boolean koniec = false;
        while (!koniec) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine(), " ");
            int mm = Integer.parseInt(stringTokenizer.nextToken());
            int dd = Integer.parseInt(stringTokenizer.nextToken());
            int yyyy = Integer.parseInt(stringTokenizer.nextToken());
            if (mm == 0 && dd == 0 && yyyy == 0){
                koniec = true;
                continue;
            }

            if (jeDatum(mm, dd, yyyy)){
                int vypocetDna = 0; // toto je 1.1.1 čo je sobota
                //všade je yyyy-1 lebo nepočítame posledný rok
                if (yyyy <= 1753) {
                    vypocetDna += (yyyy-1) * 365 + ((yyyy-1)/4); // ta druha časť je pripočítanie tých priestupných dní čo boli naviac
                } else {
                    vypocetDna += (yyyy -1 ) % 7;
                    vypocetDna += ((yyyy -1 ) / 4 - (yyyy-1)/100 + (yyyy-1)/400) + yearOfSwitch/100 - yearOfSwitch/400; // hadnlovanie rokov po 1753
                }

                //dopočet posledného roku bez posledného mesiaca
                for (int i = 0; i < mm-1; i++) {
                    vypocetDna += daysInMoths[jePriestupny(yyyy)? 1 : 0][i];
                }

                //dopočet dni z posledného mesiaca
                vypocetDna += dd-1;

                //fix kôli switchu
                if (yyyy > yearOfSwitch || (yyyy == yearOfSwitch && mm > 9) || (yyyy == yearOfSwitch && mm == 9 && dd > 13)){
                    vypocetDna -=11;
                }

                System.out.printf("%s %d, %d is a %s\n", nameOfMonths[mm-1], dd, yyyy, nameOfDays[vypocetDna%7]);
            } else {
                System.out.printf("%d/%d/%d is an invalid date.\n", mm, dd, yyyy);
            }

        }
    }

    private static boolean jeDatum(int mm, int dd, int yyyy) {
        if (mm > 12){
            return false;
        }
        if (dd > daysInMoths[jePriestupny(yyyy)? 1 : 0][mm-1]){
            return false;
        }

        //todo v pripade chyby tu môže byť problém
        //kotrola či dátum nie je v čase ked sa menilo 2->14
        return yyyy != yearOfSwitch || mm != 9 || dd <= 2 || dd >= 14;
    }

    private static boolean jePriestupny(int yyyy) {
        if (yyyy <= yearOfSwitch){
            //return yyyy % 400 == 0; // chybička se vloudila xD
            return yyyy % 4 == 0;
        } else {
            // testujeme pravidlo na storočia a ak nie je storočie tak sa testuje priestup 4
            return yyyy % 100 == 0 ? (yyyy % 400 == 0) : (yyyy % 4 == 0);
        }
    }
}
