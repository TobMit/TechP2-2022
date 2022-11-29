package TechProg2.doma2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main11503 {
    // <meno , id mena>
    private static HashMap<String, Integer> mena;
    // [0] od kial [1] kam
    private static ArrayList<int[]> pole;
    private static ArrayList<Integer> kostra;
    private static ArrayList<Integer> komponent;
    private static ArrayList<Integer> end;
    private static ArrayList<Integer> w;
    private static int pocetHranVKostre;
    private static ArrayList<Integer> pocetNode;

    private static int uPrvy, vDruhy;
    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestcase = Integer.parseInt(buffReader.readLine());
        for (int i = 0; i < numberOfTestcase; i++) {
            int count = 0;
            mena = new HashMap<>();
            /*
            pole = new ArrayList<>();
            kostra = new ArrayList<>();
            komponent = new ArrayList<>();
            end = new ArrayList<>();
            w = new ArrayList<>();
            pocetHranVKostre = 0;*/
            pocetNode = new ArrayList<>();
            // na začiatok je kopnutá nula aby som čisloval od 1 a aby mi mohli potom vycházať indexi
            pocetNode.add(0);
            int numberOfFriendships = Integer.parseInt(buffReader.readLine());
            for (int j = 0; j < numberOfFriendships; j++) {
                String[] tmpMena = buffReader.readLine().split(" ");
                int[] tmpVztah = new int[2];
                // prvý z dvojice
                if (!mena.containsKey(tmpMena[0])) {
                    int id = ++count;
                    mena.put(tmpMena[0], id);
                    tmpVztah[0] = id;
                    // -- druhy spôsob
                    pocetNode.add(-1);
                } else {
                    tmpVztah[0] = mena.get(tmpMena[0]);
                }
                // druhý z dvojice
                if (!mena.containsKey(tmpMena[1])) {
                    int id = ++count;
                    mena.put(tmpMena[1], id);
                    tmpVztah[1] = id;
                    // -- druhy spôsob
                    pocetNode.add(-1);
                } else {
                    tmpVztah[1] = mena.get(tmpMena[1]);
                }
                //pole.add(tmpVztah);

                //System.out.println(kruskal(tmpVztah[1]) + 1);
                // -- druhy spôsob
                int u = getRoot(mena.get(tmpMena[0]));
                int v = getRoot(mena.get(tmpMena[1]));

                if (u == v) {
                    System.out.println(-pocetNode.get(u));
                } else {
                    System.out.println(-spoj(u, v));
                }
            }
            //System.out.println();
        }
    }
    // ----------------- Druhy spôsob -----------------

    /**
     * Metóda vráti koreň tejto kostry, čiže várti id pre pocetNode kde sa uchováva hodnota o akutálnom počete node v danej kostre
     */
    private static int getRoot(int id) {
        if (pocetNode.get(id) < 0) {
            return id;
        } else {
            // urychlenie kažý prvok ukazuje na koren, takže netreba dlhú rekurziu ku korenu
            pocetNode.set(id, getRoot(pocetNode.get(id)));
            return pocetNode.get(id);
        }
    }

    /**
     * Vytvára "spojenie" každý prvok z kostry odkazuje na root a root držý hodnotu o všetkych prvkoch
     * hodnota je záporná aby sa jasne identifikovalo čo je id a čo je počet node v koreni
     */
    private static int spoj(int idD, int idV) {
        int x = pocetNode.get(idD) + pocetNode.get(idV);
        // nahradím jednu z dvoch záporných hodnout na id korena a hodnotu počet node v kostre
        if (pocetNode.get(idD) > pocetNode.get(idV)) {
            pocetNode.set(idD, idV);
            pocetNode.set(idV, x);
        } else {
            pocetNode.set(idD, x);
            pocetNode.set(idV, idD);
        }
        return x;
    }

    //-------------------- Pomale ---------------------
    private static int kruskal(int idHladanehoMena) {

        // krok 2
        while (komponent.size() < mena.size()) {
            int komponetSize = komponent.size();
            komponent.add(komponetSize);
            w.add(0);
            end.add(komponetSize);
            pocetNode.add(0);
        }
        // krok 3

        uPrvy = pole.get(pole.size() - 1)[0];
        vDruhy = pole.get(pole.size() - 1)[1];

        if (komponent.get(uPrvy) != komponent.get(vDruhy)) {
            pocetHranVKostre++;
            //kostra.set(pocetHranVKostre, pole.size() - 1);
            int komponentMax = Math.max(komponent.get(uPrvy), komponent.get(vDruhy));
            int komponentMin = Math.min(komponent.get(uPrvy), komponent.get(vDruhy));

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
        /*
        for (int i = 0; i < pole.size(); i++) {
            int u = pole.get(i)[0];
            int v = pole.get(i)[1];
            if (komponent[u] == komponent[v]) {
                System.out.printf("%d a %d sú kamarati!\n", u, v);
            } else {
                System.out.printf("%d a %d sú niesu!\n", u, v);
            }
        }
         */
        return pocetNode.get(komponent.get(idHladanehoMena));
    }
}
