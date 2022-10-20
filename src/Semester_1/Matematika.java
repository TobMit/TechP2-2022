package Semester_1;

import java.util.ArrayList;

/**
 * 24. 2. 2021 - 19:47
 *
 * @author Tobias
 */
public class Matematika {
    public static void main(String[] args) {
        ArrayList<Integer> cisla = new ArrayList<>();
        int hladaneCislo = 6;
        int cislo = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    cisla.add(i * 100 + j * 10 + k);
                    if ((Math.max(i, Math.max(j, k)) - Math.min(i, Math.min(j, k))) == hladaneCislo) {
                        cislo++;
                    }
                }
            }
        }
        System.out.println(cisla.size());
        System.out.println(cislo);
    }
}
