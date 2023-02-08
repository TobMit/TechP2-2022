import java.util.Scanner;
// trochu pomoci https://www.ida.liu.se/projects/progcontest/progsm/2002/prognm2002-hints.pdf
public class Main882MailBoxManufacProblem {

    private static final int MAX_VALUE = 1000000000; // max hodnota 1e9

    private static int[][][] memo = new int[11][101][101];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCase = scanner.nextInt();
        for (int i = 0; i < numberOfCase; i++) {
            int k = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(ries(k, 0, m));
        }
    }

    private static int ries(int k, int start, int m) {
        if (k == 0) {
            return MAX_VALUE;
        }
        if (k == 1){
            return (m*(m+1)/2) - (start*(start+1)/2);
        }
        if (m == start){
            return 0;
        }

        if (memo[k][start][m] == 0){
            int vysledok = MAX_VALUE;
            for (int i = start + 1; i <= m; i++) {
                vysledok = Math.min(vysledok, i + Math.max(ries(k-1, start, i-1), ries(k, i, m)));
            }
            memo[k][start][m] = vysledok;
        }
        return memo[k][start][m];
    }
}
