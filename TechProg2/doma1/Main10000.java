package TechProg2.doma1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main10000 {
    private static final Scanner scanner = new Scanner(System.in);
    private static int[][] array;
    public static void main (String[] args) {
        int testCase = 1;
        while(true) {
            int numberOfPoints = scanner.nextInt();
            if (numberOfPoints == 0) {
                return;
            }
            int startingPoint = scanner.nextInt();
            boolean loop = true;

            // sú o jedno väčšie aby označenie súhlasilo aj so stĺpcom
            array = new int[numberOfPoints + 1][numberOfPoints + 1];

            while (loop) {
                int first = scanner.nextInt();
                int second = scanner.nextInt();
                if (first == 0 && second == 0) {
                    loop = false;
                }

                array[first][second] = second;
            }
            // ------------------------------------

            prehladavjDoSirky(startingPoint, testCase);

//            for (int[] ints : array) {
//                for (int i : ints) {
//                    System.out.printf("%d ", i);
//                }
//                System.out.println();
//            }
//            System.out.println();

            testCase++;
            //Case 1: The longest path from 1 has length 1, finishing at 2.
            // \n
        }

    }

    private static void prehladavjDoSirky(int startingPoint, int nTestCase) {
        Queue<Integer> queue = new LinkedList<>();

        int pathCost = 0;
        //element na ktorom cézar skončil svoju cestu :D
        int fishElement = startingPoint;
//        for (int i = 0; i < array[startingPoint].length; i++) {
//            if (array[startingPoint][i] != 0) {
//                queue.add(array[startingPoint][i]);
//            }
//        }

        queue.add(startingPoint);
        queue.add(-1);

        // ak sa zo štartovného bodu dá dostať na ďaľšiu úroveň tak môžem pripočítať jednotku k ceste
        // taktiže môžem pridať aj značku označujúcu novú úroveň
        // -1 je značka novej úrovne
//        if (!queue.isEmpty()) {
//            pathCost++;
//            queue.add(-1);
//        }
        //cena aktuálnej úrovne
        int uroven = pathCost;
        while (!queue.isEmpty()) {

            int tmpPoint = queue.poll();
//             ak je oddelovač tak sme sa posunuli na novú úroveň
//            if (tmpPoint == -1) {
//                pathCost++;
//            }

            // ak je odelovač nie je posledný v queue znamená to že sme aktuálnu úroveň ukončili a prechádzame na novú
            // preto treba označiť že prechadzame na novú úroveň
            if (tmpPoint == -1 && !queue.isEmpty()) {
                queue.add(-1);
                uroven++;
            }


            // ak spracuvávame pointy
            if (tmpPoint != -1) {
                if (uroven > pathCost) {
                    pathCost = uroven;
                    fishElement = tmpPoint;
                }

                for (int i = 0; i < array[tmpPoint].length; i++) {
                    if (array[tmpPoint][i] != 0) {
                        queue.add(array[tmpPoint][i]);
                    }
                }
            }

        }


        System.out.printf("Case %d: The longest path from %d has length %d, finishing at %d.\n\n", nTestCase, startingPoint, pathCost, fishElement);



    }
}
