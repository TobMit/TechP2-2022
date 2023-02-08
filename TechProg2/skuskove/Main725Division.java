import java.util.Scanner;
import java.util.TreeSet;

public class Main725Division {

    // abcde / fghij = N
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean fistCase = true;
        while (true) {
            int numberN = scanner.nextInt();
            if (numberN == 0) {
                break;
            }

            if (!fistCase) {
                System.out.println(); //Medzi case treba printovať riadok ale za posledným sa nemôze vyprintovat riadok
            }
            fistCase = false;

            boolean found = false;
            for (int fghij = 1234; fghij < 98765; fghij++) {
                if (!correct(fghij)){
                    continue;
                }
                int abcde = fghij * numberN;
                if (abcde > 100000) {
                    break;
                }

                if (!correct(abcde)){
                    continue;
                }

                if (correct(String.format("%05d%05d", abcde, fghij).toCharArray())) {
                    System.out.printf("%05d / %05d = %d\n", abcde, fghij, numberN);
                    found = true;
                }
            }

            if (!found) {
                System.out.printf("There are no solutions for %d.\n", numberN);
            }


        }
    }

    private static boolean correct(int fghij) {
        TreeSet<Character> tmp = new TreeSet<>();
        char[] charFGHIJ = String.format("%05d", fghij).toCharArray();
        for (int i = 0; i < charFGHIJ.length; i++) {
            if (tmp.contains(charFGHIJ[i])){
                return false;
            }
            tmp.add(charFGHIJ[i]);
        }
        return true;
    }
    private static boolean correct(char[] fghij) {
        TreeSet<Character> tmp = new TreeSet<>();
        for (int i = 0; i < fghij.length; i++) {
            if (tmp.contains(fghij[i])){
                return false;
            }
            tmp.add(fghij[i]);
        }
        return true;
    }
}
