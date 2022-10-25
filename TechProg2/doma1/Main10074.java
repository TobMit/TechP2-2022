package TechProg2.doma1;

import java.util.Scanner;

public class Main10074 {
    private static final Scanner scanner = new Scanner(System.in);
    private static int[][] pole;

    public static void main(String[] args) {

        while (true) {

            int rows = getNextInt();
            int columns = getNextInt();

            if (rows <= 0 || columns <= 0) {
                return;
            } else {
                pole = new int[rows][columns];
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (getNextInt() == 1) {
                        pole[i][j] = 0;
                    } else {
                        pole[i][j] = 1;
                    }
                }
            }

            predpriprav(rows, columns);

            System.out.println(sracuj(rows, columns));
/*
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(pole[i][j] + " ");
            }
            System.out.println();
        }*/

        }

    }

    private static int sracuj(int rows, int columns) {
        int max = 0;
        // program spracuváva pole od vrchu
        for (int i = 0; i < rows; i++) {
            for (int aktualneID = 0; aktualneID < columns; aktualneID++) {
                int tmp = 0;
                // prehladávam do predu
                for (int k = aktualneID; k < columns ; k++) {
                    if (pole[i][aktualneID] == 0) {
                        break;
                    }
                    if (pole[i][aktualneID] <= pole[i][k]) {
                        tmp += pole[i][aktualneID];
                    } else {
                        break;
                    }
                }
                for (int k = aktualneID - 1; k >= 0 ; k--) {
                    if (pole[i][aktualneID] == 0) {
                        break;
                    }
                    if (pole[i][aktualneID] <= pole[i][k]) {
                        tmp += pole[i][aktualneID];
                    } else {
                        break;
                    }
                }
                // prehladam riadok do zadu
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        return max;
    }

    private static void predpriprav(int rows, int columns) {
        for (int i = 0; i < columns; i++) {
            for (int j = 1; j < rows; j++) {
                if (pole[j][i] != 0) {
                    pole[j][i] = pole[j][i] + pole[j-1][i];
                }
            }
        }
    }

    private static int getNextInt() {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return -1;
    }
}
