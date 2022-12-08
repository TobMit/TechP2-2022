package TechProg2.Sutaz3;

import java.util.Scanner;
import java.util.TreeMap;

public class HowToCut {
    private static TreeMap<String, Integer> domJudge;
    private static TreeMap<String, Integer> kattis;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //while (scanner.hasNext()) {
        int prve = scanner.nextInt();
        int druhe = scanner.nextInt();

        double diagonala = Math.sqrt(Math.pow(prve,2) + Math.pow(druhe,2));
        double stvorec = prve + druhe;
        double vysledok = stvorec - diagonala;
        if (vysledok%1 == 0.0) {
            System.out.printf("%d",(int) vysledok);
        } else {
            System.out.printf("%.9f", vysledok);
        }
        //System.out.println(stvorec - diagonala);
    }
}
