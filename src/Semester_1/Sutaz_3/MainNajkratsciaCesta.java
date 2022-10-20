package Semester_1.Sutaz_3;

import java.util.Scanner;
import java.util.StringTokenizer;

public class MainNajkratsciaCesta {
    private static int[][] h;
    private static int pocetSusedov;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        pocetSusedov = Integer.parseInt(scanner.nextLine());
        h = new int[pocetSusedov * pocetSusedov - pocetSusedov + 1][3];

        int pocitadlo = 0;
        for (int i = 0; i < pocetSusedov; i++) {
            StringTokenizer parser = new StringTokenizer(scanner.nextLine());
            int cislo = 1;
            while (parser.hasMoreTokens()) {
                int ohodnotenieHrany = Integer.parseInt(parser.nextToken());
                if (ohodnotenieHrany != 0) {
                    h[pocitadlo][0] = i + 1;
                    h[pocitadlo][1] = cislo;
                    h[pocitadlo][2] = ohodnotenieHrany;
                    pocitadlo++;
                    cislo++;
                } else {
                    cislo++;
                }
            }
        }

        for (int i = 0; i < h.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(h[i][j] + " ");
            }
            System.out.println();
        }
        kruskalovAlgoritmus2();

    }

    public static void kruskalovAlgoritmus2() {
        int[] kostra;
        int [] k;
        int pocetHranVkostre = 0;
        int[] end;
        int[] w;

        k = new int[pocetSusedov + 1];
        kostra = new int[pocetSusedov + 1];
        end = new int[pocetSusedov + 1];
        w = new int[pocetSusedov + 1];


        //Zotriedenie pole hrán H podla ceny hran (vzrastuco)
        shellSort(2);

        //Hrany z postupnosti P
        int u;
        int v;
        //Krok 2
        for (int i = 1; i < pocetSusedov + 1; i++) {
            k[i] = i; //Kazdy vrchol je vo svojom vlastnom komponente
            w[i] = 0;
            end[i] = i;
        }


        for (int j = 1; j < h.length; j++) {
            u = h[j][0];
            v = h[j][1];

            if (k[u] != k[v]) {
                pocetHranVkostre++;

                //Na riadku j sme nasli hranu, ktoru zaradime do kostry
                kostra[pocetHranVkostre] = j;
                int kmax = Math.max(k[u], k[v]);
                int kmin = Math.min(k[u], k[v]);
                //Pomale
//                for (int i = 1; i < this.n + 1; i++) {
//                    if (k[i] == kmax) {
//                        k[i] = kmin;
//                    }
//                }
                for (int ti = kmax; w[ti] > 0; ti = w[ti]) {
                    k[ti] = kmin;
                }
                k[end[kmax]] = kmin;
                w[end[kmin]] = kmax;
                end[kmin] = end[kmax];
                end[kmax] = 0;
            }
        }
        // Vypocet ceny kostry
        int cenaKostry = 0;
        for (int j = 1; j < pocetHranVkostre + 1; j++) {
            cenaKostry += h[j][2];
        }

        //Vypis algoritmu
        System.out.println("Pocet hran kostry je " + pocetHranVkostre);
        System.out.println("Cena kostry je " + cenaKostry);
//        System.out.println("Hrany kostry su: ");
//        for (int i = 1; i < pocetHranVkostre + 1; i++) {
//            int r = kostra[i];
//            System.out.printf("[%d, %d]\n", this.H[i][0], this.H[i][1]);
//        }
    }

    private static void shellSort(int s) {
        //double gap;
        int gap;
        for (gap = (h.length) / 2 + 1; gap >= 1; gap = ( 5 * gap / 11)) {
            if (gap == 2) {
                gap = 3;
            }
            for (int i = 1; i + gap <= h.length - 1; i++) {
                int j = i + gap;
                int k;
                if (h[i][s] > h[j][s]) {
                    swap(i, j);
                    for (k = i; k - gap >= 1; k = k - gap) {
                        int l = k - gap;
                        if (h[l][s] <= h[k][s]) {
                            break;
                        }
                        swap(l, k);
                    }
                }
            }
        }
    }

    private static void swap(int i, int j) {
        int odlozenieH;
        for (int k = 0; k <= 2; k++) {
            odlozenieH = h[i][k];
            h[i][k] = h[j][k];
            h[j][k] = odlozenieH;
        }
    }
}
