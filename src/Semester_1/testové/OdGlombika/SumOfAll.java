package Semester_1.testové.OdGlombika;
import java.util.*;

public class SumOfAll {
    private static boolean moznost = true;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String vstup = scanner.nextLine();
            String[] pole = vstup.split(" ");
            if (Integer.parseInt(pole[0]) == 0) {
                continue;
            }
            System.out.println("Sums of " + pole[0] + ":");

            ArrayList<Integer> cisla = new ArrayList<>();

            for (int j = 2; j < pole.length; j++) {
                if (Integer.parseInt(pole[j]) <= Integer.parseInt(pole[0])) {
                    cisla.add(Integer.parseInt(pole[j]));
                }

            }
            Collections.sort(cisla);
            Collections.reverse(cisla);

            skombinuj(cisla, Integer.parseInt(pole[0]));
        }


    }

    static void skombinuj(ArrayList<Integer> A, int K)
    {
        ArrayList<Integer> local = new ArrayList<>();
        triedicka(0, 0, K, local, A);
        if (moznost) {
            System.out.println("NONE");
        }
        moznost = true;
    }

    static void triedicka(int l, int sum, int K, ArrayList<Integer> pole, ArrayList<Integer> A) {

        if (sum == K) {
            moznost = false;
            for (int i = 0; i < pole.size(); i++) {
                if (i != 0)
                    System.out.print("");
                System.out.print(pole.get(i));
                if (i != pole.size() - 1)
                    System.out.print("+");
            }
            System.out.println("");
            return;
        }


        for (int i = l; i < A.size(); i++) {
            if (sum + A.get(i) > K)
                continue;

            if (i > l && A.get(i) == A.get(i - 1) )
                continue;

            pole.add(A.get(i));

            triedicka(i + 1, sum + A.get(i), K,
                    pole, A);

            pole.remove(pole.size() - 1);
        }
    }

}

