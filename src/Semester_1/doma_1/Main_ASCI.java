package Semester_1.doma_1;

import java.util.Scanner;

public class Main_ASCI {
    //private static String[] nula;
    private static String[][] znaky = new String[11][7];

    private static String[] plus = new String[7];

    public static void main(String[] args) {

        Main_ASCI.nacitajMatice();

        Scanner scanner = new Scanner(System.in);
        //riešený vstup
        String[] input = new String[7];
        for (int riadok = 0; riadok < 7; riadok++) {
            input[riadok] = scanner.nextLine() + ".";
        }

        String[][] rozdelenyInput = new String[input[1].length() / 6][7];

        ///System.out.println(input.length);

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < rozdelenyInput.length; j++) {
                rozdelenyInput[j][i] = input[i].substring(j * 6, (j + 1) * 6);
            }
        }

        String[] imputAkoStringoveCislo = new String[rozdelenyInput.length];
        String prveCislo = "";
        String druheCislo = "";
        for (int i = 0; i < rozdelenyInput.length; i++) {
            imputAkoStringoveCislo[i] = vratAkoCislo(rozdelenyInput[i]);
        }

        boolean rozdelovac = false;
        for (int i = 0; i < imputAkoStringoveCislo.length; i++) {
            if (imputAkoStringoveCislo[i].equals("10")) {
                rozdelovac = true;
                continue;
            }
            if (!rozdelovac) {
                prveCislo += imputAkoStringoveCislo[i];
            } else {
                druheCislo += imputAkoStringoveCislo[i];
            }

        }
        zobrazVysledok(Integer.parseInt(prveCislo) + Integer.parseInt(druheCislo));
    }

    private static String vratAkoCislo(String[] cislo) {
        int[] buffer = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


        for (int i = 0; i < cislo.length; i++) {
            for (int j = 0; j < buffer.length; j++) {
                if (!cislo[i].equals(Main_ASCI.znaky[j][i])) {
                    buffer[j] = -1;
                }
            }
        }
        for (int i : buffer) {
            if (i != -1) {
                return String.valueOf(i);
            }
        }
        return null;
    }

    private static void zobrazVysledok(int vstupneCislo) {
        int dlzkaCisla = (int) (Math.log10(vstupneCislo) + 1);
        //System.out.println(dlzka);
        int[] cisla = new int[dlzkaCisla];

        //cisla[1] = cislo % 100;

        for (int pozicia = 0; pozicia < dlzkaCisla; pozicia++) {

            cisla[pozicia] = vstupneCislo % 10;
            vstupneCislo = vstupneCislo / 10;
        }

        for (int riadok = 0; riadok < 7; riadok++) {
            for (int cislo = dlzkaCisla; cislo > 0; cislo--) {
                System.out.print(znaky[cisla[cislo - 1]][riadok].substring(0, 5));
                if (cislo > 1) {
                    System.out.print(".");
                }
            }
            System.out.println();
        }

    }

    private static void nacitajMatice() {
        Main_ASCI.znaky[0][0] = "xxxxx.";
        Main_ASCI.znaky[0][1] = "x...x.";
        Main_ASCI.znaky[0][2] = "x...x.";
        Main_ASCI.znaky[0][3] = "x...x.";
        Main_ASCI.znaky[0][4] = "x...x.";
        Main_ASCI.znaky[0][5] = "x...x.";
        Main_ASCI.znaky[0][6] = "xxxxx.";

        Main_ASCI.znaky[1][0] = "....x.";
        Main_ASCI.znaky[1][1] = "....x.";
        Main_ASCI.znaky[1][2] = "....x.";
        Main_ASCI.znaky[1][3] = "....x.";
        Main_ASCI.znaky[1][4] = "....x.";
        Main_ASCI.znaky[1][5] = "....x.";
        Main_ASCI.znaky[1][6] = "....x.";

        Main_ASCI.znaky[2][0] = "xxxxx.";
        Main_ASCI.znaky[2][1] = "....x.";
        Main_ASCI.znaky[2][2] = "....x.";
        Main_ASCI.znaky[2][3] = "xxxxx.";
        Main_ASCI.znaky[2][4] = "x.....";
        Main_ASCI.znaky[2][5] = "x.....";
        Main_ASCI.znaky[2][6] = "xxxxx.";
//---------------------------------------
        Main_ASCI.znaky[3][0] = "xxxxx.";
        Main_ASCI.znaky[3][1] = "....x.";
        Main_ASCI.znaky[3][2] = "....x.";
        Main_ASCI.znaky[3][3] = "xxxxx.";
        Main_ASCI.znaky[3][4] = "....x.";
        Main_ASCI.znaky[3][5] = "....x.";
        Main_ASCI.znaky[3][6] = "xxxxx.";

        Main_ASCI.znaky[4][0] = "x...x.";
        Main_ASCI.znaky[4][1] = "x...x.";
        Main_ASCI.znaky[4][2] = "x...x.";
        Main_ASCI.znaky[4][3] = "xxxxx.";
        Main_ASCI.znaky[4][4] = "....x.";
        Main_ASCI.znaky[4][5] = "....x.";
        Main_ASCI.znaky[4][6] = "....x.";

        Main_ASCI.znaky[5][0] = "xxxxx.";
        Main_ASCI.znaky[5][1] = "x.....";
        Main_ASCI.znaky[5][2] = "x.....";
        Main_ASCI.znaky[5][3] = "xxxxx.";
        Main_ASCI.znaky[5][4] = "....x.";
        Main_ASCI.znaky[5][5] = "....x.";
        Main_ASCI.znaky[5][6] = "xxxxx.";

        Main_ASCI.znaky[6][0] = "xxxxx.";
        Main_ASCI.znaky[6][1] = "x.....";
        Main_ASCI.znaky[6][2] = "x.....";
        Main_ASCI.znaky[6][3] = "xxxxx.";
        Main_ASCI.znaky[6][4] = "x...x.";
        Main_ASCI.znaky[6][5] = "x...x.";
        Main_ASCI.znaky[6][6] = "xxxxx.";

        Main_ASCI.znaky[7][0] = "xxxxx.";
        Main_ASCI.znaky[7][1] = "....x.";
        Main_ASCI.znaky[7][2] = "....x.";
        Main_ASCI.znaky[7][3] = "....x.";
        Main_ASCI.znaky[7][4] = "....x.";
        Main_ASCI.znaky[7][5] = "....x.";
        Main_ASCI.znaky[7][6] = "....x.";

        Main_ASCI.znaky[8][0] = "xxxxx.";
        Main_ASCI.znaky[8][1] = "x...x.";
        Main_ASCI.znaky[8][2] = "x...x.";
        Main_ASCI.znaky[8][3] = "xxxxx.";
        Main_ASCI.znaky[8][4] = "x...x.";
        Main_ASCI.znaky[8][5] = "x...x.";
        Main_ASCI.znaky[8][6] = "xxxxx.";

        Main_ASCI.znaky[9][0] = "xxxxx.";
        Main_ASCI.znaky[9][1] = "x...x.";
        Main_ASCI.znaky[9][2] = "x...x.";
        Main_ASCI.znaky[9][3] = "xxxxx.";
        Main_ASCI.znaky[9][4] = "....x.";
        Main_ASCI.znaky[9][5] = "....x.";
        Main_ASCI.znaky[9][6] = "xxxxx.";

        Main_ASCI.znaky[10][0] = "......";
        Main_ASCI.znaky[10][1] = "..x...";
        Main_ASCI.znaky[10][2] = "..x...";
        Main_ASCI.znaky[10][3] = "xxxxx.";
        Main_ASCI.znaky[10][4] = "..x...";
        Main_ASCI.znaky[10][5] = "..x...";
        Main_ASCI.znaky[10][6] = "......";
    }
}

