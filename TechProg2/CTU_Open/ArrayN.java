import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ArrayN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.println(1000000000);
        int n = scanner.nextInt();


        long currRow = 3l;
        ArrayList<Long> prev = new ArrayList<Long>();
        ArrayList<Long> curr = new ArrayList<>();
        HashMap<Long, Long> cisla = new HashMap<>();
        curr.add(1l);
        curr.add(2l);
        curr.add(1l);
        cisla.put(2l,3l);


        for (int i = 0; i < n; i++) {
            long cislo = scanner.nextInt();
            if (cislo == 1) {
                System.out.println("1");
                continue;
            }

            boolean dostDogenerovane = false;

            while (!dostDogenerovane) {
                prev.clear();
                prev.addAll(curr);
                curr.clear();
                currRow++;
                int counter = 0;
                //System.out.print(currRow + ": ");
                for (int j = 0; j < prev.size() + 1; j++) {
                    if (j == 0 || (j == prev.size() && prev.size() == currRow - 1)) {
                        curr.add(1l);
                    } else {
                        if (counter == 1) {
                            break;
                        }
                        long added = (prev.get(j - 1) + prev.get(j));
                        if (added > Math.pow(10, 9)) {
                            dostDogenerovane = true;
                            break;
                        }
                        //System.out.print(added + " ");
                        if (added < curr.get(j - 1)) {
                            counter++;
                        }
                        curr.add(added);
                        if (!cisla.containsKey(added)) {
                            cisla.put(added, currRow);
                        }

                    }
                }
                //System.out.println();
            }

            if (!cisla.containsKey(cislo)) {
                System.out.println(cislo + 1);
            } else {
                System.out.println(cisla.get(cislo));
            }
        }


        /*//long[][] tmp = new long[35][35];
        ArrayList<ArrayList<Long>> tmp = new ArrayList<>(100);
        for (int i = 0; i < tmp.size(); i++) {
            boolean end = false;
            for (int j = 0; j < i+1; j++) {
                if (j == 0 || j == i) {
                    tmp[i][j] = 1;
                    if ()
                } else {
                    tmp[i][j] = tmp[i-1][j-1] + tmp[i-1][j];
                    if (!hladac.containsKey(tmp[i][j])) {
                        hladac.put(tmp[i][j],i+1);
                    }
                }
            }
        }

        /*
        for (int i = 0; i < n; i++) {
            long cislo = scanner.nextInt();

            if (cislo == 1) {
                System.out.println("1");
            } else {
                System.out.println(hladac.get(cislo));
            }
        }*/

        // 1
        // 1 1
        // 1 2 1
        // 1 3   31


        // 1 5 10 5 1
        // 1 6 16
    }
}
