package TechProg2.Sutaz3;

import java.util.Scanner;

public class MainSaveJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //while (scanner.hasNext()) {
        int numberOfTestCase = scanner.nextInt();
        for (int i = 0; i < numberOfTestCase; i++) {
            int numberOfCities = scanner.nextInt();
            int numberOfPersonal = scanner.nextInt();
            int[][] hrany = new int[numberOfPersonal + 1][2];
            for (int j = 0; j < numberOfPersonal; j++) {
                hrany[j][0] = scanner.nextInt();
                hrany[j][1] = scanner.nextInt();
            }
            System.out.println(customKruskal(hrany, numberOfCities, numberOfPersonal));
        }


    }

    private static long customKruskal(int[][] hrany, int pocetMiest, int pocetHran) {
        // 1 - vynchavam
        // 2 - krok
        long sizeOfSpanTree = 0;
        int[] komponent = new int[pocetMiest + 1];
        for (int i = 0; i < pocetMiest + 1; i++) {
            komponent[i] = i;
        }

        // krok 3
        for (int i = 0; i < pocetHran; i++) {
            //if (findRoot(hrany.get(i).x) != findRoot(hrany.get(i).y) ) {
            if (findRoot(hrany[i][0], komponent) != findRoot(hrany[i][1], komponent) ) {
                //spoj(hrany.get(i).x, hrany.get(i).y, komponent);
                spoj(hrany[i][0], hrany[i][1], komponent);
                sizeOfSpanTree++;
            }
        }
        return sizeOfSpanTree;


        //return 0;
    }

    private static int findRoot(int idKomponentu, int[] komponent) {
        if (idKomponentu == komponent[idKomponentu]) {
            return idKomponentu;
        } else {
            komponent[idKomponentu] = findRoot(komponent[idKomponentu], komponent);
            return komponent[idKomponentu];
        }
    }
    private static void spoj(int first, int second, int[] komponent) {
        komponent[findRoot(first, komponent)] = findRoot(komponent[second], komponent);
    }
}
