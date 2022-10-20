package Semester_1.skuskove;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main331 {
    private static int [] h;
    private static int skok = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            StringTokenizer parser = new StringTokenizer(input);
            int mnozstvo = Integer.parseInt(parser.nextToken());
            if (mnozstvo == 0) {
                return;
            }
            h = new int[mnozstvo];
            int poradie = 0;
            while (parser.hasMoreTokens()) {
                h[poradie] = Integer.parseInt(parser.nextToken());
                poradie++;
            }

            //shellSort(0);
            System.out.printf("There are %d swap maps for input data set %d.\n", Main331.skok, mnozstvo);
            for (int i : h) {
                System.out.print(" " + i);
            }
            System.out.println();
            skok = 0;

        }
    }

    private static void shellSort(int s) {
        //double gap;
        int gap;
        for (gap = h.length - 1 / 2 + 1; gap >= 1; gap = ( 5 * gap / 11)) {
            if (gap == 2) {
                gap = 3;
            }
            //System.out.printf("gap = %d\n", gap);
            for (int i = 1; i + gap <= h.length; i++) {
                int j = i + gap;
                int k;
                if (h[i] > h[j]) {
                    Main331.swap(i, j);
                    for (k = i; k - gap >= 1; k = k - gap) {
                        int l = k - gap;
                        if (h[l] <= h[k]) {
                            break;
                        }
                        Main331.swap(l, k);
                    }
                }
            }
        }
    }

    private static void swap(int i, int j) {
        int odlozenieH;
        skok++;
        for (int k = 0; k <= 2; k++) {
            odlozenieH = h[i];
            h[i] = h[j];
            h[j] = odlozenieH;
        }
    }
}
