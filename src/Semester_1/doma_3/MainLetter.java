package Semester_1.doma_3;

import java.util.*;

public class MainLetter {
    private static int[][] h;
    private static int m;
    private static int n;
    private static int[] t;
    private static int[] x;

    private static ArrayList<String> zoznam;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, String> zoznamTree = new TreeMap<>();
        TreeMap<String, Integer> zoznamTreeOpacny = new TreeMap<>();
        zoznam = new ArrayList<>();
        int pocetOpakovanie = Integer.parseInt(scanner.nextLine());
        scanner.nextLine();
        for (int i = 0; i < pocetOpakovanie; i++) {
            int pocet = 0;
            while (true) {
                String slovo = scanner.nextLine();
                if (slovo.equals("*")) {
                    break;
                }
//                zoznamTree.put(pocet, slovo);
//                zoznamTreeOpacny.put(slovo, pocet);
                zoznam.add(slovo);
                pocet++;
            }

//            h = new int[pocet * pocet][3];
//            generujH(zoznam, zoznamTree);
//            m = pocet * pocet;
//            n = pocet;
//            t = new int[n + 1];
//            x = new int[n + 1];

//            for (int j = 0; j < h.length; j++) {
//                System.out.printf("%d %d %d\n", h[j][0], h[j][1], h[j][2]);
//            }
//            System.out.println();

            while (scanner.hasNext()) {
                String riadok = scanner.nextLine();
                if (riadok.isEmpty()) {
                    break;
                }
                StringTokenizer parser = new StringTokenizer(riadok);
//                int prvy = zoznamTreeOpacny.get(parser.nextToken());
//                int druhy = zoznamTreeOpacny.get(parser.nextToken());
//                System.out.printf("%s %s %d\n", zoznamTree.get(prvy), zoznamTree.get(druhy), najdiCestu(prvy, druhy));
                String prvy = parser.nextToken();
                String druhy = parser.nextToken();
                System.out.printf("%s %s %d\n", prvy, druhy, najdiCestu(prvy, druhy));


            }
            if (i + 1 < pocetOpakovanie) {
                System.out.println();
            }
            zoznam.clear();
        }
    }

    private static int najdiCestu(String prvy, String druhy) {
        Set<String> pouzite = new HashSet<>();
        Queue<String> poradie = new LinkedList<>();

        poradie.add(prvy);
        pouzite.add(prvy);

        int zmena = 0;

        while (!poradie.isEmpty()) {
            int pocetPrvkovVPoradi = poradie.size();
            for (int i = 0; i < pocetPrvkovVPoradi; i++) {
                String spracovavaneSlovo = poradie.poll();

                if (spracovavaneSlovo.equals(druhy)) {
                    return zmena;
                }

                char[] spracSlovoArr = spracovavaneSlovo.toCharArray();
                for (String naPorovnanie : zoznam) {
                    char[] naPorovanieArr = naPorovnanie.toCharArray();
                    if (spracovavaneSlovo.equals(naPorovnanie)) {
                        continue;
                    }
                    if (spracovavaneSlovo.length() != naPorovnanie.length()) {
                        continue;
                    }

                    int pocetZmien = 0;
                    for (int j = 0; j < spracSlovoArr.length; j++) {
                        if (spracSlovoArr[j] == naPorovanieArr[j]) {
                            continue;
                        }
                        pocetZmien++;
                    }

                    if (pocetZmien == 1) {
                        if (!pouzite.contains(naPorovnanie)) {
                            poradie.add(naPorovnanie);
                            pouzite.add(naPorovnanie);
                        }
                    }

                }

            }
            zmena++;
        }
        return 0;
    }

    private static void generujH(ArrayList<String> zoznam, TreeMap<Integer, String> zoznamTree) {
        int poradie = 0;
        for (int i = 0; i < zoznam.size() - 1; i++) {
            for (int j = 0; j < zoznam.size(); j++) {
//
                if (zoznam.get(i).equals(zoznam.get(j))) {
                    continue;
                }

                char[] prvyVyraz = zoznam.get(i).toCharArray();
                char[] druhyVyraz = zoznam.get(j).toCharArray();

                if (prvyVyraz.length - druhyVyraz.length > 1 || druhyVyraz.length - prvyVyraz.length > 1) {
                    continue;
                }
                int pocetZmien = 0;
                for (int f = 0; f < prvyVyraz.length && f < druhyVyraz.length; f++) {
                    if (prvyVyraz[f] == druhyVyraz[f]) {
                        continue;
                    }
                    pocetZmien++;
                }
                if (pocetZmien > 1) {
                    continue;
                }

                h[poradie][0] = i;
                h[poradie][1] = j;
                h[poradie][2] = 1;
                poradie++;

            }
        }
    }

    private static int najdiCestuU(int zaciatok, int koniec, TreeMap<Integer, String> zoznamTree) {
        int v;
        int u;

        u = zaciatok;
        v = koniec;


        for (int i = 0; i <= n; i++) {
            t[i] = Integer.MAX_VALUE / 2 - 2;
            x[i] = 0;
        }

        //Hodnota zaciatocneho vrcholu na 0
        t[u] = 0;

        //2.Krok

        boolean zlesenie = true;

        while (zlesenie) {
            zlesenie = false;


            for (int k = 1; k <= m - 1 ; k++) {
                //Zaciatok hrany
                int i = h[k][0];
                //Koniec hrany
                int j = h[k][1];
                //Cena hrany
                int cij = h[k][2];

                if (t[j] > t[i] + cij) {
                    t[j] = t[i] + cij;
                    x[j] = i;
                    zlesenie = true;
                }

            }
        }

//        int w = v;
//        System.out.println(zoznamTree.get(w));
//        while (x[w] > 0) {
//            System.out.println(zoznamTree.get(x[w]));
//            w = x[w];
//        }

        return t[v];
    }
}