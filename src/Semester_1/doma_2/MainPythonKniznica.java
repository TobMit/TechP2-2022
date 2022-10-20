package Semester_1.doma_2;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class MainPythonKniznica {
    public static void main(String[] args) {
    //public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(new FileInputStream("src/testCase.txt"));

        Scanner scanner = new Scanner(System.in);
        int pocetTestCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < pocetTestCases; i++) {
            /*              Môže byť aj prázdna, treba to opraviť!!!      */

            String oldKniznica = scanner.nextLine();
            String newKniznica = scanner.nextLine();

            oldKniznica = oldKniznica.replace("{", "");
            oldKniznica = oldKniznica.replace("}", "");
            newKniznica = newKniznica.replace("{", "");
            newKniznica = newKniznica.replace("}", "");

            StringTokenizer rozdelovac = new StringTokenizer(oldKniznica, ",");
            TreeMap<String, String > staraKniznica = new TreeMap<>();

            while (rozdelovac.hasMoreTokens()) {
                StringTokenizer finalnerozdelenie = new StringTokenizer(rozdelovac.nextToken(), ":");
                staraKniznica.put(finalnerozdelenie.nextToken(), finalnerozdelenie.nextToken());
            }

            StringTokenizer rozdelovacNova = new StringTokenizer(newKniznica, ",");
            TreeMap<String, String > novaKniznica = new TreeMap<>();

            while (rozdelovacNova.hasMoreTokens()) {
                StringTokenizer finalnerozdelenie = new StringTokenizer(rozdelovacNova.nextToken(), ":");
                novaKniznica.put(finalnerozdelenie.nextToken(), finalnerozdelenie.nextToken());
            }

            findRozdiel(staraKniznica, novaKniznica);
            System.out.println();

        }
    }

    private static void findRozdiel(TreeMap<String, String> staraKniznica, TreeMap<String, String> novaKniznica) {
        // prvý otuput
        String noveZnaky = null;
        for (String nova : novaKniznica.keySet()) {
            if (staraKniznica.containsKey(nova)) {
                continue;
            }
            if (noveZnaky == null) {
                noveZnaky = "+" + nova;
                continue;
            }
            noveZnaky += "," + nova;
        }

        if (noveZnaky != null) {
            System.out.println(noveZnaky);
        }

        // druhý output a treti output
        String zmazane = null;
        String zmenenaHodnota = null;
        for (String stara : staraKniznica.keySet()) {
            if (novaKniznica.containsKey(stara)) {
                if (staraKniznica.get(stara).equals(novaKniznica.get(stara))) {
                    continue;
                }
                if (zmenenaHodnota == null) {
                    zmenenaHodnota = "*" + stara;
                    continue;
                }
                zmenenaHodnota += "," + stara;

                continue;
            }
            if (zmazane == null) {
                zmazane = "-" + stara;
                continue;
            }
            zmazane += "," + stara;
        }

        if (zmazane != null) {
            System.out.println(zmazane);
        }

        if (zmenenaHodnota != null) {
            System.out.println(zmenenaHodnota);
        }


        // stvrte overeni zadnych zmien
        if (zmenenaHodnota == null && zmazane == null && noveZnaky == null) {
            System.out.println("No changes");
        }

    }
}