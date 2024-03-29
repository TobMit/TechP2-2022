package TechProg2.doma2;

import java.util.Scanner;

public class Main10721 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int riadok = 0;
        boolean zaporne = false;
        while (scanner.hasNext()) {
            // sirka BarCode
            int n = scanner.nextInt();
            // pocet cisel v BarCode
            int k = scanner.nextInt();
            // sirka jednoho cisla
            int m = scanner.nextInt();

            System.out.println(pocitaj(n, k , m));
        }

    }

    private static long pocitaj(int n, int k, int m) {
        // riadky sú širka BarCode
        // stlpec sú počet prvkov
        // vďaka tomuto môžem napočitavať postupne všetky kombinácie od 1 až po požadovanú veľkosť
        // v záverečnom cikle sa napočitávajú jednotlivé možnosti pre rôzne širky čisla
        // najlešpie je si to napísať do tb pre lepšie pochopene (pre budúceho mňa xD)
        long[][] memorization = new long[50][50];
        // nastavím prvý stlpec - na 1 kde to vychýza po širku znaku
        for (int i = 0; i < n && i < m; i++) {
            memorization[i][0] = 1;
        }

        // dynamické programovaine  I gess
        // postupné budovanie pamete pre postupné zvyšovanie počtu znakov
        for (int pocetZnakov = 1; pocetZnakov < k; pocetZnakov++) {
            // postupné zvyšovanie širky barcode kde spočitavam celú širku znaku resp jeho kombinácie
            for (int sirkaBarcode = pocetZnakov; sirkaBarcode < n; sirkaBarcode++) {
                // postupné spočitavanie všetkých možnosti na základe širky znaku kde postupne počitavam všetky možnosti širky znaku o 1 až po širku znaku
                for (int sirkaZnaku = 1; sirkaZnaku <= m && sirkaZnaku <= sirkaBarcode; sirkaZnaku++) {
                    memorization[sirkaBarcode][pocetZnakov] += memorization[sirkaBarcode - sirkaZnaku][pocetZnakov - 1];
                }
            }
        }

        // musím to posunúť o - 1 aby to fungovalo správne, idem od 0 tak preto musí byť posunúté o - 1
        return memorization[n - 1][k - 1];
    }
}
