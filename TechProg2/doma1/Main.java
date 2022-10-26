package TechProg2.doma1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Integer>[] array;
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
            array = new ArrayList[numberOfPoints+1];

            while (loop) {
                int first = scanner.nextInt();
                int second = scanner.nextInt();
                if (first == 0 && second == 0) {
                    loop = false;
                }

                if (array[first] == null) {
                    array[first] = new ArrayList<Integer>();
                    array[first].add(second);
                } else {
                    array[first].add(second);
                }

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

        //cena aktuálnej úrovne
        int uroven = 0;

        //max velkost je 100
        int[] navstivene = new int[101];
        //potrebujem naplniť vzialenosti na zapornú hodnotu, čo indikuje že ešte nebolo navštívené
        Arrays.fill(navstivene, -1);
        while (!queue.isEmpty()) {

            int tmpPoint = queue.poll();


            // ak je odelovač nie je posledný v queue znamená to že sme aktuálnu úroveň ukončili a prechádzame na novú
            // preto treba označiť že prechadzame na novú úroveň
            if (tmpPoint == -1 && !queue.isEmpty()) {
                queue.add(-1);
                uroven++;
            }
            // ak spracuvávame pointy
            else if (tmpPoint != -1) {
                // kontrola či z nižšej úrovne viac krát nenachádzama ten istý point
                if (uroven > navstivene[tmpPoint]) {

                    navstivene[tmpPoint] = uroven;

                    if (uroven > pathCost) {
                        pathCost = uroven;
                        fishElement = tmpPoint;
                    } else if (uroven == pathCost && fishElement > tmpPoint) {
                        fishElement = tmpPoint;
                    }

                    if (array[tmpPoint] != null) {
                        for (int i = 0; i < array[tmpPoint].size(); i++) {
                            if (array[tmpPoint].get(i) != 0) {
                                queue.add(array[tmpPoint].get(i));
                            }
                        }
                    }
                }
            }

        }


        System.out.printf("Case %d: The longest path from %d has length %d, finishing at %d.\n\n", nTestCase, startingPoint, pathCost, fishElement);



    }
}
