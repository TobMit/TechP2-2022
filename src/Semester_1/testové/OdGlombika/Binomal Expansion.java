package Semester_1.testové.OdGlombika;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;


class BinomalExpansion {
    public static void main(String [] arguments) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> retazec= new ArrayList<>();

        String[] pole2 = new String[50];
        pole2 = printPascal(51);

        int k = 0;
        int caseNumber = scanner.nextInt();
        if (caseNumber <= 0) {
            return;
        }
            while (scanner.hasNext()) {
                String celyRiadok = scanner.nextLine();
                StringTokenizer delic = new StringTokenizer(celyRiadok, "(+)^");
                ArrayList<String> pole = new ArrayList<>();

                while (delic.hasMoreTokens()) {
                    pole.add(delic.nextToken());
                }
                if (!pole.isEmpty()) {
                    int a = Integer.parseInt(pole.get(2));
                    String riadok = pole2[a];
                    retazec.add(series(pole.get(0), pole.get(1), a, riadok));
                }
                k++;
                if (k > caseNumber) {
                    for (int i = 0; i < k - 1; i++) {
                        StringTokenizer rozdelovac = new StringTokenizer(retazec.get(i), "[, ]");
                        System.out.print("Case " + (i + 1) + ": ");
                        while (rozdelovac.hasMoreTokens()) {
                            System.out.print(rozdelovac.nextToken());
                        }
                        System.out.println("");
                    }
                    break;
                }
            }





    }

    static String series(String prvy, String druhy,long n, String riadok) {

        String[] kombinaCisla = riadok.split(" ");
        ArrayList<String> finalnyVypis = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            long vysledok = Long.valueOf(kombinaCisla[i]);
            if (n == 2) {
                finalnyVypis.add(prvy+"^2+"+"2*"+prvy+"*"+druhy+"+"+druhy+"^2");
                return finalnyVypis.toString();
            }
            if (n == 1) {
                finalnyVypis.add(prvy+"+"+druhy);
                break;
            } else {
            if (i == 0) {
                finalnyVypis.add(prvy+"^"+n +"+");
            } else if (i > 0 && i < n) {
                if (i == 1) {
                    finalnyVypis.add(vysledok +"*"+ prvy + "^" + (n - i) + "*" + druhy + "+");
                } else if (i == n - 1) {
                    finalnyVypis.add(vysledok +"*"+ prvy + "*" + druhy + "^" + i + "+");
                } else {
                    finalnyVypis.add(vysledok +"*"+ prvy + "^" + (n - i) + "*" + druhy + "^" + i + "+");
                }


            } else {
                finalnyVypis.add(druhy+"^"+n);
            }
            }

        }
        return finalnyVypis.toString();
    }
    public static String[] printPascal(int n) {

        String[] pole = new String [51];
        String riadok ="";
        long[][] arr = new long[n][n];

        for (int line = 0; line < n; line++)
        {
            for (int i = 0; i <= line; i++)
            {
                if (line == i || i == 0) {
                    arr[line][i] = 1;

                } else
                    arr[line][i] = arr[line-1][i-1] + arr[line-1][i];
                riadok += Long.toString(arr[line][i])+" ";
                //System.out.print(arr[line][i]);
            }
            pole[line] = riadok;
            riadok="";

        }
        for (String s : pole) {
            System.out.println(s);;
        }
        return pole;
    }




}