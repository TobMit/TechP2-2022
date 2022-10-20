package Semester_1.cvicenie_4;

import java.util.Scanner;


// 8 dám
public class MainOsmeDam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pocetVstupov = scanner.nextInt();
        int[][] sachovnica = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sachovnica[i][j] = 0;
            }

        }

        int[][] suradnice = new int[pocetVstupov][2];

        for (int i = 0; i < pocetVstupov; i++) {
            scanner.nextLine();
            suradnice[i][0] = scanner.nextInt();
            suradnice[i][1] = scanner.nextInt();

        }



        for (int i = 0; i < pocetVstupov; i++) {
            sachovnica[suradnice[i][0] - 1][suradnice[i][1] - 1] = 1;
            /*
            int riadokY = suradnice[i][0] - 1;
            int stlpecX = suradnice[i][1] - 1;
            for (int j = 1; j < 8; j++) {
                riadokY++;
                stlpecX++;
                if ((riadokY > 7) || (stlpecX > 7)) {
                    if (riadokY > stlpecX) {
                        riadokY = riadokY - stlpecX;
                        stlpecX = 0;
                    } else if (riadokY < stlpecX) {
                        stlpecX = stlpecX - riadokY;
                        riadokY = 0;
                    } else {
                        riadokY = 0;
                        stlpecX = 0;
                    }
                } else if (riadokY == (suradnice[i][0] - 1)) {
                    break;
                }
                System.out.printf("%d %d\n", riadokY, stlpecX);
                sachovnica[riadokY][stlpecX] = 2;
                System.out.println("\n\n  1 2 3 4 5 6 7 8");
                for (int k = 0; k < 8; k++) {
                    System.out.printf("%d ", k + 1);
                    for (int l = 0; l < 8; l++) {
                        System.out.print(sachovnica[k][l] + " ");
                    }
                    System.out.println();
                }
            }
            System.out.println("\n\n  1 2 3 4 5 6 7 8");
            for (int j = 0; j < 8; j++) {
                System.out.printf("%d ", j + 1);
                for (int k = 0; k < 8; k++) {
                    System.out.print(sachovnica[j][k] + " ");
                }
                System.out.println();
            }*/

            if (generujSachovnicu(1, sachovnica)) {
                if (jeOkHorzontala(sachovnica, 2, 4)) {
                    System.out.println("je ok");
                }

                System.out.println("Má riešenie");
                System.out.println("\n\n   1 2 3 4 5 6 7 8");
                for (int k = 0; k < 8; k++) {
                    System.out.printf("%d  ", k + 1);
                    for (int l = 0; l < 8; l++) {
                        System.out.print(sachovnica[k][l] + " ");
                    }
                    System.out.println();
                }
            }
        }




    }

    private static boolean generujSachovnicu(int riadok, int[][] sachovnica) {
        if (riadok >= 8) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            if (sachvnicaJeOk(sachovnica, i, riadok)) {
                sachovnica[i][riadok] = 1;
                if (generujSachovnicu(riadok + 1, sachovnica)) {
                    return true;
                }
                sachovnica[i][riadok] = 0;
            }


        }
        return false;
    }

    private static boolean sachvnicaJeOk(int[][] sachovnica, int riadok, int stlpec) {

        if (!jeOkVertikala(sachovnica, riadok, stlpec)) {
            return false;
        } else if (!jeOkHorzontala(sachovnica, riadok, stlpec)) {
            return false;
        } else if (!jeOkDiagonala(sachovnica, riadok, stlpec)) {
            return false;
        } else if (!jeOkVedlajsiaDiagonala(sachovnica, riadok, stlpec)) {
            return false;
        }
        return true;
    }



    private static boolean jeOkVertikala(int[][] sachovnica, int riadok, int stlpec) {
        for (int i = 1; i < 8; i++) {
            if (sachovnica[riadok][(stlpec + i) % 8] == 1) {
                //System.out.println("Neprešla prvov podmienkov");
                return false;
            }
            //System.out.println("prešla prvou podmienkov");
        }
        return true;
    }

    private static boolean jeOkHorzontala(int[][] sachovnica, int riadok, int stlpec) {
        for (int i = 1; i < 8; i++) {
            if (sachovnica[(riadok + i) % 8][stlpec] == 1) {
                //System.out.println("Neprešla prvov podmienkov");
                return false;
            }
            //System.out.println("prešla prvou podmienkov");
        }
        return true;
    }

    private static boolean jeOkDiagonala(int[][] sachovnica, int riadok, int stlpec) {
        int riadokY = riadok;
        int stlpecX = stlpec;

        for (int i = 1; i < 8; i++) {
            riadokY++;
            stlpecX++;
            if ((riadokY > 7) || (stlpecX > 7)) {
                if (riadokY > stlpecX) {
                    riadokY = riadokY - stlpecX;
                    stlpecX = 0;
                } else if (riadokY < stlpecX) {
                    stlpecX = stlpecX - riadokY;
                    riadokY = 0;
                } else {
                    riadokY = 0;
                    stlpecX = 0;
                }
            } else if (riadokY == riadok) {
                return true;
            }

            if (sachovnica[riadokY][stlpecX] == 1) {
                //System.out.println("Neprešla prvov podmienkov");
                return false;
            }
            //System.out.println("prešla prvou podmienkov");
        }
        return true;
    }
    private static boolean jeOkVedlajsiaDiagonala(int[][] sachovnica, int riadok, int stlpec) {
        int riadokY = riadok;
        int stlpecX = stlpec;
        for (int i = 1; i < 8; i++) {
            if ((riadokY <= 0) || (stlpecX >= 7)) {
                int odlozenie = riadokY;
                riadokY = stlpecX;
                stlpecX = odlozenie;

            } else {
                riadokY--;
                stlpecX++;
            }
            if (riadokY == riadok) {
                return true;
            }

            if (sachovnica[riadokY][stlpecX] == 1) {
                //System.out.println("Neprešla prvov podmienkov");
                return false;
            }
            //System.out.println("prešla prvou podmienkov");
        }
        return true;
    }








}
