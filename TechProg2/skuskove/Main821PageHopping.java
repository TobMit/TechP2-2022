import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=762
public class Main821PageHopping {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestcase = 0;
        while (true != false) {
            String input = reader.readLine();
            if (input.equals("0 0")){
                break;
            }

            // krok 1
            int[][] map = new int[101][101];
            for (int i = 0; i < 101; i++) {
                Arrays.fill(map[i], 1000000);
            }

            StringTokenizer tokenizer = new StringTokenizer(input, " ");

            int maxNode = 1; // kôli cyklu aby som vedel po kadial ma bežat floyd-warshall
            while (tokenizer.hasMoreTokens()) {
                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());
                if (a + b == 0) {
                    break;
                }
                map[a][b] = 1;
                maxNode = Math.max(maxNode, Math.max(a, b)); // zistím navyšši node
            }

            // Floyd-Warshal algoritmus na vytvorenie matice vzdialenosti (všetky možnosti)

            //krok 2
            for (int k = 1; k <= maxNode; k++) {
                for (int i = 1; i <= maxNode; i++) {
                    for (int j = 1; j <= maxNode; j++) {
                        int tmp = Math.min(map[i][j], map[i][k] + map[k][j]);
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }

            //Spočitanie cesty
            double suma = 0;
            double pocet = 0;

            for (int i = 1; i <= maxNode; i++) {
                for (int j = 1; j <= maxNode; j++) {
                    if (i != j  && map[i][j] < 1000000) {
                        pocet++;
                        suma += map[i][j];
                    }
                }
            }
            System.out.printf("Case %d: average length between pages = %.3f clicks\n",++numberOfTestcase, suma/pocet);
        }
    }
}
