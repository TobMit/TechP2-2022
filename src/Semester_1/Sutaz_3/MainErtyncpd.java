package Semester_1.Sutaz_3;

import java.util.ArrayList;
import java.util.Scanner;

public class MainErtyncpd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int numberOfcolumns = Integer.parseInt(scanner.nextLine());
            if (numberOfcolumns == 0) {
                return;
            }
            spracuj(scanner.nextLine(), numberOfcolumns);

        }
    }

    private static void spracuj(String input, int numberOfcolumns) {
        int dlzka = input.length();
        //System.out.println(dlzka);
        //System.out.println(dlzka / numberOfcolumns);
        ArrayList<String[]> tabulka = new ArrayList<>();
        char[] rodelenie = input.toCharArray();
        boolean odPredu = true;
        for (int i = 0; i < input.length();) {
            String[] riadok = new String[numberOfcolumns];
            if (odPredu) {
                for (int j = 0; j < numberOfcolumns; j++) {
                    riadok[j] = Character.toString(rodelenie[i]);
                    i++;
                }
                odPredu = false;
                tabulka.add(riadok);
            } else {
                int ukazovac = i + numberOfcolumns - 1;
                for (int j = 0; j < numberOfcolumns; j++) {
                    riadok[j] = Character.toString(rodelenie[ukazovac]);
                    ukazovac--;
                    i++;
                }
                odPredu = true;
                tabulka.add(riadok);
            }
        }

//        for (String[] strings : tabulka) {
//            for (String string : strings) {
//                System.out.print(string + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < numberOfcolumns; i++) {
            for (int j = 0; j < tabulka.size(); j++) {
                String[] riadok = tabulka.get(j);
                System.out.print(riadok[i]);
            }
        }
        System.out.println();

        //String[input.length()/]
    }
}
