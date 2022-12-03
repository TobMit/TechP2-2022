package TechProg2.doma2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1160 {
    private static ArrayList<Pair> hrany;
    private static int[] komponent;
    private static HashMap<Integer, Integer> zoznamLatok;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            boolean koniecTestCase = false;
            hrany = new ArrayList<>();
            zoznamLatok = new HashMap<>();
            int countChcemicals = 0;
            while (!koniecTestCase) {
                StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine(), " ");
                int prveCislo = Integer.parseInt(stringTokenizer.nextToken());

                if (prveCislo == -1) {
                    koniecTestCase = true;
                    continue;
                }
                int druheCislo = Integer.parseInt(stringTokenizer.nextToken());
                if (!zoznamLatok.containsKey(prveCislo)) {
                    zoznamLatok.put(prveCislo,countChcemicals++);
                }
                if (!zoznamLatok.containsKey(druheCislo)) {
                    zoznamLatok.put(druheCislo,countChcemicals++);
                }
                Pair tmpHrana = new Pair();
                tmpHrana.x = zoznamLatok.get(prveCislo);
                tmpHrana.y = zoznamLatok.get(druheCislo);
                hrany.add(tmpHrana);
                //System.out.println(prveCislo + " " + druheCislo);
            }
            System.out.println(hrany.size() - customKruskal());

            // medzi testCase sú volné riadky tak aby som to kompenzoval
            if (scanner.hasNext()) {
                scanner.nextLine();
            }

            // vypočet je Celkový počet hrán - kostra
        }
    }

    // Princíp fungovania veľmi podobný 11503 a 10397 dokonca niektoré časti kódu sú identická kopia
    // bližžie popísanie fungovania je vysvetlené tam
    private static int customKruskal() {
        int sizeOfSpanTree = 0;
        komponent = new int[zoznamLatok.size() + 1];

        // krok 1 - preskočneie
        // krok 2
        for (int i = 0; i < zoznamLatok.size() + 1; i++) {
            komponent[i] = i;
        }

        // krok 3
        for (int i = 0; i < hrany.size(); i++) {
            if (findRoot(hrany.get(i).x) != findRoot(hrany.get(i).y) ) {
                spoj(hrany.get(i).x, hrany.get(i).y);
                sizeOfSpanTree++;
            }
        }
        return sizeOfSpanTree;
    }

    private static void spoj(int first, int second) {
        komponent[findRoot(first)] = findRoot(komponent[second]);
    }

    private static int findRoot(int idKomponentu) {
        if (idKomponentu == komponent[idKomponentu]) {
            return idKomponentu;
        } else {
            komponent[idKomponentu] = findRoot(komponent[idKomponentu]);
            return komponent[idKomponentu];
        }
    }

    private static class Pair {
        public int x;
        public int y;
    }
}
