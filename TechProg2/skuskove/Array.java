import java.util.HashMap;
import java.util.Scanner;
// Zadanie vo filoch
public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.println(1000000000);
        int n = scanner.nextInt();


        //long[][] tmp = new long[68][68];
        HashMap<Long, Integer> hladac = new HashMap<>();
        //ArrayList<ArrayList<Long>> tmp = new ArrayList<>(100);
        for (int i = 0; i < 100000; i++) {
            //System.out.print(i +". ");
            long row = 1;
            for (int j = 0; j < i+1; j++) {
                row *= i - j;
                row /= j + 1;
                if (row > 1000000000) {
                    break;
                }
                if (!hladac.containsKey(row)) {
                    hladac.put(row,i+1);
                }
            }
            //System.out.println();
        }


        for (int i = 0; i < n; i++) {
            long cislo = scanner.nextInt();

            if (cislo == 1) {
                System.out.println("1");
            } else {
                if (hladac.containsKey(cislo)) {
                    System.out.println(hladac.get(cislo));
                } else {
                    System.out.println(cislo+1);
                }
            }
        }

    }
}
