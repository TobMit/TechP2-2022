package TechProg2.doma1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main10653 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int nRow = scanner.nextInt();
            int nColum = scanner.nextInt();

            if (nRow == 0 && nColum == 0){
                break;
            }

            // vytvorenie "hracej" plochy, true == bomba
            boolean[][] land = new boolean[nRow][nColum];
            int nRowOfBombs = scanner.nextInt();
            for (int i = 0; i < nRowOfBombs; i++) {
                int rowNumber = scanner.nextInt();
                int nBombs = scanner.nextInt();
                for (int j = 0; j < nBombs; j++) {
                    int columNumber = scanner.nextInt();
                    land[rowNumber][columNumber] = true;
                }
            }

            // prvá súradnica je row a potom column
            Pair<Integer, Integer> startingPoint = new Pair<>(scanner.nextInt(), scanner.nextInt());
            Pair<Integer, Integer> finshPoint = new Pair<>(scanner.nextInt(), scanner.nextInt());


            //-------------------------- bfs časť ---------------------------------
            boolean found = false;
            //  x y
            int[][] pohybRobota = new int[][]{{0,1},{1,0},{-1,0}, {0,-1}};
            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
            queue.add(startingPoint);
            int nSteps = 0;
            // budem prechádzať strom pokiaľ nenájdem alebo neprejdem všetky možnosti
            while (!queue.isEmpty() && !found) {
                // prejdem všetky možnosti v danom kroku
                int qSize = queue.size();
                for (int i = 0; i < qSize; i++) {
                    Pair<Integer, Integer> tmp = queue.poll();

                    // toto som nepobral prečo to musim natvrdo pretipovávať
                    if ((int)tmp.getRow() == (int)finshPoint.getRow() && (int)tmp.getColumn() == (int)finshPoint.getColumn()) {
                        found = true;
                        break;
                    }

                    // prechádzam všetky smeri
                    for (int[] ints : pohybRobota) {
                        int newRow = tmp.row + ints[0];
                        int newColum = tmp.column + ints[1];

                        // kontrola ohraničenosti
                        if (newRow < 0 || newColum < 0 || newRow >= nRow || newColum >= nColum) {
                            continue;
                        }

                        //kontrola či som už daľší prvok nenaštívil
                        if (land[newRow][newColum]) {
                            continue;
                        }
                        queue.add(new Pair<>(newRow, newColum));
                        // označenie že bude naštívený
                        land[newRow][newColum] = true;
                    }
                }

                // ak som nenašiel, tak prejdem o krok dalej
                if (!found) {
                    nSteps++;
                }
            }
            System.out.println(nSteps);
        }
    }

    /**
     * Pomocná trieda pre prehľadnejšie ukladanie súradníc
     */
    private static class Pair<K, D> {
        private final K row;
        private final D column;

        public Pair(K pRight, D pLeft) {
            this.row = pRight;
            this.column = pLeft;
        }

        public K getRow() {
            return row;
        }

        public D getColumn() {
            return column;
        }
    }
}

