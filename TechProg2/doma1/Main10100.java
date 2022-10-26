package TechProg2.doma1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main10100 {
    public static void main (String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCase = 0;
        String row1;
        String row2;
        while((row1 = bufferedReader.readLine()) != null) {
            row2= bufferedReader.readLine();
            testCase++;
            if (row1 == null) {
                break;
            }
            // odstránenie NonAlphanumeric
            row1 = row1.replaceAll("[^a-zA-Z0-9]", " ");
            row2 = row2.replaceAll("[^a-zA-Z0-9]", " ");


            if (row1.length() == 0 || row2.length() == 0) {
                System.out.printf("%2d. Blank!\n", testCase);
                continue;
            }

            int longestMatch = 0;


            System.out.printf("%2d. Length of longest match: %d\n", testCase, longestMatch);
        }

    }

}
