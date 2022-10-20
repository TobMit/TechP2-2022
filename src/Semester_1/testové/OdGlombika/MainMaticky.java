package Semester_1.testové.OdGlombika;
import java.util.HashMap;
import java.util.Scanner;

public class MainMaticky {
    private static HashMap<String, int[]> matice = new HashMap<>();
    private static int medziVysledky = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pocet = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < pocet; i++) {
            String line = scanner.nextLine();
            //uloz(line);
        }

        while (scanner.hasNext()) {
            String vstup = scanner.next();
            spracuj(vstup);
        }


    }

//    public static void uloz(String line) {
//        String[] splited = line.split(" ");
//        int[] cisla = new int[2];
//        cisla[0] = Integer.parseInt(splited[1]);
//        cisla[1] = Integer.parseInt(splited[2]);
//        matice.put(splited[0], cisla);
//    }

    public static void spracuj(String line) {
        if (line.length() == 1) {
            System.out.println("0");
            return;
        }
        int hodnota = 0;
        String modifikovany = line;

        while (modifikovany.length() > 2) {
//            System.out.println(modifikovany);
            char[] znaky = modifikovany.toCharArray();
            int indexPravejZatvorky = 0;
            int indexLavejZazvorky = 0;

            for (int i = 0; i < znaky.length; i++) {
                if (znaky[i] == ')') {
                    indexPravejZatvorky = i;
                    break;
                }
            }

            for (int i = indexPravejZatvorky; i >= 0; i--) {
                if (znaky[i] == '(') {
                    indexLavejZazvorky = i;
                    break;
                }
            }

            String vypocet = modifikovany.substring(indexLavejZazvorky, indexPravejZatvorky + 1);

            int vysledok = vypocitaj(vypocet);

            if (vysledok == 0) {
                System.out.println("error");
                return;
            }
            hodnota += vysledok;

            modifikovany = modifikovany.replace(vypocet, "" + (medziVysledky - 1));
        }
        medziVysledky = 0;
        System.out.println(hodnota);
    }

    public static int vypocitaj(String input) {
        String vstup = input.replace(" ", "");//--------------------------------------------------------------
        vstup = vstup.replace("(", "");
        vstup = vstup.replace(")", "");

        char[] hodnoty = vstup.toCharArray();
        String hodnota1 = String.valueOf(hodnoty[0]);
        String hodnota2 = String.valueOf(hodnoty[1]);

        int[] matica1 = matice.get(hodnota1);
        int[] matica2 = matice.get(hodnota2);

        if (matica1[1] != matica2[0]) {
            return 0;
        } else {
            int[] vysledok = {matica1[0], matica2[1]};

            matice.put("" + medziVysledky, vysledok);
            medziVysledky++;

            return matica1[1] * matica1[0] * matica2[1];
        }
    }
}
