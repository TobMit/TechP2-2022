package Semester_1.skuskove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.HashMap;

public class Main443 {
    private static final HashMap<String, Integer> list = new HashMap();
    private static final HashMap<Integer, String> reversList = new HashMap<>();

    /**
	 * Problem 443
     * @value -1 signaluzuje že sa niečo nenašlo alebo je neplatné
     * v poliach d[][] a dRaw[][] na hneď prvý elemen nevyužíva
     */

    public static void main(String[] args) throws IOException {
        list.put(" _ | ||_|", 0); // 0
        list.put("     |  |", 1); // 1
        list.put(" _  _||_ ", 2); // 2
        list.put(" _  _| _|", 3); // 3
        list.put("   |_|  |", 4); // 4
        list.put(" _ |_  _|", 5); // 5
        list.put(" _ |_ |_|", 6); // 6
        list.put(" _   |  |", 7); // 7
        list.put(" _ |_||_|", 8); // 8
        list.put(" _ |_| _|", 9); // 9

        for (String znacka : list.keySet()) {
            reversList.put(list.get(znacka), znacka);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int noTestCases = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < noTestCases; i++) {
            String[] dRaw = new String[10];
            // d[1-9] [0-9]
            // d[1-9] [...] - pradové číslo (prvá zátvokra)
            // d[...] [0-9] - poradové číslo 0 je číslo ktoré ma 100% zhodu (druhá zátvorka)
            //            - poradové číslo 1... je číslo ktoré ma < 100% zhodu (druhá zátvorka)
            Integer[][] d = new Integer[10][11];
            Arrays.fill(dRaw, "");
            for (int j = 0; j < 3; j++) {
                String riadok = bufferedReader.readLine();
                riadok += "                        ";
                dRaw[9] += riadok.substring(0, 3);
                dRaw[8] += riadok.substring(3, 6);
                dRaw[7] += riadok.substring(6, 9);
                dRaw[6] += riadok.substring(9, 12);
                dRaw[5] += riadok.substring(12, 15);
                dRaw[4] += riadok.substring(15, 18);
                dRaw[3] += riadok.substring(18, 21);
                dRaw[2] += riadok.substring(21, 24);
                dRaw[1] += riadok.substring(24, 27);
            }
            int hladanyIndex = -1;
            for (int j = 1; j < d.length; j++) {
                d[j][0] = list.get(dRaw[j]);
                //naplní zoznam číslami ktoré sa potom budú mazať
                for (int k = 1; k <= 9; k++) {
                    d[j][k] = k;
                }
                //aby desiate číslo v poradí bola 0
                d[j][10] = 0;


                /**
                 * celé overovanie funguje na princípe menej "pridávania" znakov.
                 * Tento cyklus generuje aliasi k čísam napríklad z 1 vieme spraviť 3, 8, 9....
                 */
                // indexCisla je poradové císlo v d[][indexCisla]
                for (int indexCisla = 1; indexCisla <= 10; indexCisla++) {
                    // indexI = je poradie v danom reťazci na overenie
                    for (int indexI = 0; indexI < 9; indexI++) {
                        int tempcislo = d[j][indexCisla];
                        //overuje znak po znaku a ak sa zhodujú alebo v dRaw je medzera (a nemala by tam byť) tak sa znak zachováva ako alias k danému číslu
                        //v inom prípade sa znak zo zoznamu maže
                        if (tempcislo != -1) {
                            if (d[j][0] != null) {
                                if (tempcislo == d[j][0]) {
                                    d[j][indexCisla] = -1;
                                }
                            }
                            if (dRaw[j].charAt(indexI) == reversList.get(tempcislo).charAt(indexI) || dRaw[j].charAt(indexI) == ' ') {
                                continue;
                            } else {
                                d[j][indexCisla] = -1;
                                break;
                            }
                        }
                    }
                }

                if (d[j][0] == null) {
                    hladanyIndex = j;
                }
            }



            Main443.vyries(d.clone(), hladanyIndex);


        }
    }

    private static void vyries(Integer[][] dClone, int hladanyIndex) {
        // nastávajú 2 prípady ktoré treba vyriešiť
        // 1. prípad je taký kde poznáme pokazené číslo
        // 2. prípad je taký kde hneď rozpoznané číslo je platné a pri ďaľšom overovaní je traba ho vinechať
        // 3. prípad je taký kde sú všetky čísla dobré a treba nájsť ktoré je pokazené

        int pocetRieseni = 0;
        boolean najdeneRiesenie = false;
        int hodnotaAliasu = -1;

        Integer[][] odlozeneMatickaSkakava = dClone.clone();

        /*
        Prípad č. 1
         */
        if (hladanyIndex != -1) {
            for (int indexAliasu = 1; indexAliasu <= 10; indexAliasu++) {
                Integer[][] tmpMatica = dClone.clone();

                if (tmpMatica[hladanyIndex][indexAliasu] != -1) {
                    tmpMatica[hladanyIndex][0] = tmpMatica[hladanyIndex][indexAliasu];

                    int vysledok = spocitaj(tmpMatica);

                    if (vysledok % 11 == 0) {
                        najdeneRiesenie = true;
                        pocetRieseni += 1;
                        hodnotaAliasu = dClone[hladanyIndex][indexAliasu];
                    }
                }
            }
            // keď sa nájde riešenie a je práve jedno tak sa priradí do výslednej matice na výpis ak sa nenájde tak nič sa neprepisuje
            if (pocetRieseni == 1) {
                dClone[hladanyIndex][0] = hodnotaAliasu;
            }
        }

        /*
        Prípad č. 2
         */
        int zaciatokOverovaniaAliasov = 0;
        if (hladanyIndex == -1) {
            int vypocet = spocitaj(dClone);
            if (vypocet % 11 == 0) {
                pocetRieseni += 1;
                //toto zrejme bude treba odchecknút
                najdeneRiesenie = true;
                zaciatokOverovaniaAliasov = 1;
            }
        }

        /*
        Prípad č. 3
         */

        if (!najdeneRiesenie && hladanyIndex == -1) {
            int tmpIndexCisla = -1;
            int tmpIndexAliasu = -1;

            // indexCisla -> dClone[x]
            for (int indexCisla = 1; indexCisla <= 9; indexCisla++) {
                // indexAliasu -> dClone[...][x]
                for (int indexAliasu = zaciatokOverovaniaAliasov; indexAliasu <= 10; indexAliasu++) {
                    Integer[][] tmpDnove = odlozeneMatickaSkakava.clone();
//                    Float[][] tmpDnove = new Float[100][100];
//                    for (int i = 0; i < 10; i++) {
//                        for (int j = 0; j < 11; j++) {
//                            if (dClone[i][j] != null) {
//                                tmpDnove[i][j] = Float.valueOf(dClone[i][j]);
//                            }
//                        }
//                    }
                    if (tmpDnove[indexCisla][indexAliasu] != -1) {
                        int tmp = tmpDnove[indexCisla][0];
                        tmpDnove[indexCisla][0] = tmpDnove[indexCisla][indexAliasu];


                        int vysledok = spocitaj(tmpDnove);
                        if (vysledok % 11 == 0) {
                            najdeneRiesenie = true;
                            pocetRieseni += 1;
                            hodnotaAliasu = dClone[indexCisla][indexAliasu];
                            tmpIndexCisla = indexCisla;
                        }
                        tmpDnove[indexCisla][0] = tmp;
                    }
                }

                //Ak sa nájde práve jedno riešenie matice tak sa prepíše na 0 pozíciu ako hlavné a keď nie tak sa nič nedeje vo výpise je pre null prípad postarané
                if (pocetRieseni > 1) {
                    break;
                }
            }

            if (pocetRieseni == 1) {
                dClone[tmpIndexCisla][0] = hodnotaAliasu;
            }
        }

        if (najdeneRiesenie) {
            if (pocetRieseni == 1) {
                System.out.printf("%d%d%d%d%d%d%d%d%d\n", dClone[9][0], dClone[8][0], dClone[7][0], dClone[6][0], dClone[5][0], dClone[4][0], dClone[3][0], dClone[2][0], dClone[1][0]);
            } else {
                System.out.println("ambiguous");
            }
        } else {
            System.out.println("failure");
        }

    }

    private static int spocitaj(Integer[][] d) {
        int medzisuset = 0;
        for (int i = 1; i <= 9; i++) {
            medzisuset += (i * d[i][0]);
        }

        return medzisuset;
    }

    private static int spocitaj(Float[][] d) {
        int medzisuset = 0;
        for (int i = 1; i <= 9; i++) {
            medzisuset += (i * d[i][0]);
        }

        return medzisuset;
    }
}
