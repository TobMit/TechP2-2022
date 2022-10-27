package TechProg2.doma1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



//public class Main10100 {
public class Main10100 {
    public static void main (String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCase = 0;
        String row1;
        String row2;
        while((row1 = bufferedReader.readLine()) != null) {
            row2= bufferedReader.readLine();
            testCase++;

            // odstránenie NonAlphanumeric
            row1 = row1.replaceAll("[^a-zA-Z0-9]", " ");
            row2 = row2.replaceAll("[^a-zA-Z0-9]", " ");

            if (row1.length() == 0 || row2.length() == 0) {
                System.out.printf("%2d. Blank!\n", testCase);
                continue;
            }

            ArrayList<String> arrListRow1 = new ArrayList<String>();
            ArrayList<String> arrListRow2 = new ArrayList<String>();
            StringTokenizer stringTokenizer1 = new StringTokenizer(row1, " ");
            while (stringTokenizer1.hasMoreTokens()) {
                arrListRow1.add(stringTokenizer1.nextToken());
            }

            StringTokenizer stringTokenizer2 = new StringTokenizer(row2, " ");
            while (stringTokenizer2.hasMoreTokens()) {
                arrListRow2.add(stringTokenizer2.nextToken());
            }



            System.out.printf("%2d. Length of longest match: %d\n", testCase, longestCommonSubsequenceBottomUp(arrListRow1, arrListRow2));
        }

    }

    private static int longestCommonSubsequenceBottomUp(ArrayList<String> arrListRow1, ArrayList<String> arrListRow2) {
        //inicializacia DP[m+1][n+1], i, j
        // for (i = 0; i <= m; i++){
        //      for (j = 0; j <= n; j++){
        //          if (i == 0 || j == 0)
        //              DP[i][j] = 0;
        //          else if (X[i -1] == Y[j -1] )
        //              DP[i][j] = DP[i -1][j -1] + 1;
        //          else
        //              DP[i][j] = max(DP[i -1][j], DP[i][j -1]);
        //          }
        //      }
        //      return DP[m][n];

        int[][] DP = new int[arrListRow1.size() +1 ][arrListRow2.size() + 1];

        for (int i = 0; i <= arrListRow1.size(); i++) {
            for (int j = 0; j <= arrListRow2.size(); j++) {
                if (i == 0 || j == 0) {
                    DP[i][j] = 0;
                } else if (arrListRow1.get(i - 1).equals(arrListRow2.get(j - 1))) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = maxValue(DP[i - 1][j], DP [i][j - 1]);
                }
            }
        }
        return DP[arrListRow1.size()][arrListRow2.size()];
    }

    private static int maxValue(int i, int j) {
        if (i >= j) {
            return i;
        } else {
            return j;
        }
    }

}
