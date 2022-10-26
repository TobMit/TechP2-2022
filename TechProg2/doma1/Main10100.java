package TechProg2.doma1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


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

            int longestMatch = 0;


            System.out.printf("%2d. Length of longest match: %d\n", testCase, longestMatch);
        }

    }

}
