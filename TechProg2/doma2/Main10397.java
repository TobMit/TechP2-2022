package TechProg2.doma2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;

public class Main10397 {
    public static int[] komponent;
    public static ArrayList<Hrana> hrany;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int pocetSpojenych = 0;
            int numberOfBuildings = scanner.nextInt();
            Pair[] budovySuradnice = new Pair[numberOfBuildings + 1];
            for (int i = 1; i <= numberOfBuildings; i++) {
                budovySuradnice[i] = new Pair();
                budovySuradnice[i].first = scanner.nextInt();
                budovySuradnice[i].second = scanner.nextInt();
            }
            ArrayList<Pair> hrany = new ArrayList<>(1000);

            nastavPoleKomponenntov(numberOfBuildings);

            int numberOfOldCable = scanner.nextInt();
            for (int i = 0; i < numberOfOldCable; i++) {
                int first = scanner.nextInt();
                int second = scanner.nextInt();

                // skontrolujem či nepatria do rovnakého komponentu
                if (findRoot(first) != findRoot(second)) {
                    pocetSpojenych++;
                    spoj(first, second);
                }

            }

            generateHrany(numberOfBuildings, budovySuradnice);

            System.out.printf("%.2f\n",customKruskal());
        }
    }

    private static double customKruskal() {
        double cost = 0;
        // krok 1
        Collections.sort(hrany,
                (k1, k2) -> k1.cena < k2.cena ? (k1.cena == k2.cena ? 0 : -1) : 1); // custom komparator, kruskal potrebuje v prvom kroku zoradiť od najmenšieho po najväčšie

        // krok 2 - hotovo už pri načitavani dát a pri generovani hrán
        // krok 3
        /* //kod z 11503 kruskalov algoritums (pôvodne z hodin ATG)
        uPrvy = pole.get(pole.size() - 1)[0];
        vDruhy = pole.get(pole.size() - 1)[1];

        if (komponent.get(uPrvy) != komponent.get(vDruhy)) {
            pocetHranVKostre++;
            //kostra.set(pocetHranVKostre, pole.size() - 1);
            int komponentMax = Math.max(komponent.get(uPrvy), komponent.get(vDruhy));
            int komponentMin = Math.min(komponent.get(uPrvy), komponent.get(vDruhy));
            //get root a union
            for (int j = komponentMax; w.get(j) > 0 ; j = w.get(j)) {
                pocetNode.set(komponent.get(j), pocetNode.get(komponent.get(j))- 1);
                komponent.set(j, komponentMin);
                pocetNode.set(komponentMin, pocetNode.get(komponentMin) + 1);
            }
            komponent.set(end.get(komponentMax), komponentMin);
            pocetNode.set(komponentMin, pocetNode.get(komponentMin) + 1);
            w.set(end.get(komponentMin),komponentMax);
            end.set(komponentMin, end.get(komponentMax));
            end.set(komponentMax, 0);


        }
        */
        for (int i = 0; i < hrany.size(); i++) {
            if (findRoot(hrany.get(i).x) != findRoot(hrany.get(i).y) ) {
                spoj(hrany.get(i).x, hrany.get(i).y);
                cost += hrany.get(i).cena;
            }
        }

        //todo nezabudni zakomentovat
        //System.out.printf("");
        return cost;
    }

    private static void generateHrany(int numberOfBuildings, Pair[] budovy) {
        hrany = new ArrayList<>(281625); // najhorsi možny prípad
        int count = 0;
        for (int i = 1; i <= numberOfBuildings; i++) {
            for (int j = i + 1; j <= numberOfBuildings; j++) {

                if (findRoot(i) != findRoot(j)) {
                    Hrana tmpHrana = new Hrana();
                    tmpHrana.x = i;
                    tmpHrana.y = j;
                    tmpHrana.cena = budovy[i].vypocitajCenu(budovy[j]);
                    hrany.add(tmpHrana);
                }
            }
        }
    }

    /**
     * Podobne ako pri 11503 spojí zaradí nový komponent do druhého, keby sú to dva väčšie komponenty, tak treba najsť ich root, preto to find
     */
    private static void spoj(int first, int second) {
        komponent[findRoot(first)] = findRoot(komponent[second]);
    }

    /**
     * Inicializuje pole
     */
    private static void nastavPoleKomponenntov(int numberOfBuildings) {
        komponent = new int[numberOfBuildings + 1];
        for (int i = 1; i <= numberOfBuildings; i++) {
            komponent[i] = i;
        }
    }

    /**
     * Najde root komponentu a keď dalsi patri do toho komponentu tak id priozi aby sa urychlilo vyhladavanie korena
     */
    private static int findRoot(int idKomponentu) {
        if (idKomponentu == komponent[idKomponentu]) {
            return idKomponentu;
        } else {
            komponent[idKomponentu] = findRoot(komponent[idKomponentu]);
            return komponent[idKomponentu];
        }
    }

    private static class Pair {
        public int first;
        public int second;

        /**
         * Vypočíta cenu hrany medzi dvom akomponentami
         * @param druhyBod druhy bod voči ktorému sa vypočítava zdialenosť
         * @return cenu danej hrany
         */
        public double vypocitajCenu(Pair druhyBod) {
            return Math.sqrt((Math.pow(first - druhyBod.first, 2 )) + (Math.pow(second - druhyBod.second, 2)));
        }
    }

    private static class Hrana {
        public int x;
        public int y;
        public double cena;

    }
}
