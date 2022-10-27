package TechProg2.doma1;

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
                    land[rowNumber][scanner.nextInt()] = true;
                }
            }

            // prvá súradnica je row a potom column
            Pair<Integer, Integer> startingPoint = new Pair<>(scanner.nextInt(), scanner.nextInt());
            Pair<Integer, Integer> finshPoint = new Pair<>(scanner.nextInt(), scanner.nextInt());


            // bfs časť
            boolean found = false;
            //  x y
            int[][] pohybRobota = new int[][]{{0,1},{1,0}, {0,-1}, {-1,0}};
            System.out.println();
        }
    }

    /**
     * Pomocná trieda pre prehľadnejšie ukladanie súradníc
     */
    private static class Pair<K, D> {
        private final K right;
        private final D left;

        public Pair(K pRight, D pLeft) {
            this.right = pRight;
            this.left = pLeft;
        }

        public K getRight() {
            return right;
        }

        public D getLeft() {
            return left;
        }
    }
}

