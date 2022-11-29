package TechProg2.doma2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main11503 {
    // <meno , id mena>
    private static HashMap<String, Integer> mena;
    // [0] od kial [1] kam
    private static ArrayList<int[]> pole;
    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestcase = Integer.parseInt(buffReader.readLine());
        for (int i = 0; i < numberOfTestcase; i++) {
            mena = new HashMap<>();
            pole = new ArrayList<>();
            int count = 0;
            int numberOfFriendships = Integer.parseInt(buffReader.readLine());
            for (int j = 0; j < numberOfFriendships; j++) {
                String[] tmpMena = buffReader.readLine().split(" ");
                int[] tmpVztah = new int[2];
                // prvý z dvojice
                if (!mena.containsKey(tmpMena[0])) {
                    int id = count++;
                    mena.put(tmpMena[0], id);
                    tmpVztah[0] = id;
                } else {
                    tmpVztah[0] = mena.get(tmpMena[0]);
                }
                // druhý z dvojice
                if (!mena.containsKey(tmpMena[1])) {
                    int id = count++;
                    mena.put(tmpMena[1], id);
                    tmpVztah[1] = id;
                } else {
                    tmpVztah[1] = mena.get(tmpMena[1]);
                }
                pole.add(tmpVztah);

                System.out.println(kruskal(tmpVztah[1]) + 1);
            }
            //System.out.println();
        }
    }

    private static int kruskal(int idHladanehoMena) {
        int [] kostra = new int[mena.size() + 1];
        int [] komponent = new int[mena.size() + 1];
        int [] end = new int[mena.size() + 1];
        int [] w = new int[mena.size() + 1];
        int pocetHranVKostre = 0;
        int [] pocetNode = new int[mena.size() + 1];

        int uPrvy, vDruhy;
        // krok 2
        for (int i = 0; i < mena.size(); i++) {
            komponent[i] = i;
            w[i] = 0;
            end[i] = i;
        }

        // krok 3
        for (int i = 0; i < pole.size(); i++) {
            uPrvy = pole.get(i)[0];
            vDruhy = pole.get(i)[1];

            if (komponent[uPrvy] != komponent[vDruhy]) {
                pocetHranVKostre++;
                kostra[pocetHranVKostre] = i;
                int komponentMax = Math.max(komponent[uPrvy], komponent[vDruhy]);
                int komponentMin = Math.min(komponent[uPrvy], komponent[vDruhy]);

                for (int j = komponentMax; w[j] > 0 ; j = w[j]) {
                    pocetNode[komponent[j]]--;
                    komponent[j] = komponentMin;
                    pocetNode[komponentMin]++;
                }
                komponent[end[komponentMax]] = komponentMin;
                pocetNode[komponentMin]++;
                w[end[komponentMin]] = komponentMax;
                end[komponentMin] = end[komponentMax];
                end[komponentMax] = 0;
            }

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
        return pocetNode[komponent[idHladanehoMena]];
    }
}
