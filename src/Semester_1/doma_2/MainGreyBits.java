package Semester_1.doma_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainGreyBits {
    public static void main(String[] args) throws IOException {
        //ArrayList<Integer> grayCodeList = grayCode(30, 1073741824);
        //System.out.println(grayCodeList);
        //Scanner scanner = new Scanner(System.in);
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println(grayCodeList.size() + " 1073741824");
        int numerOfCases = Integer.parseInt(bufferReader.readLine());
        for (int i = 0; i < numerOfCases; i++) {
            String vstup = bufferReader.readLine();
            StringTokenizer parsovanie = new StringTokenizer(vstup, " ");
            int n = Integer.parseInt(parsovanie.nextToken());
            int k = Integer.parseInt(parsovanie.nextToken());
            //System.out.println(grayCodeList.get(k));
            System.out.println(gray(k));

        }
        bufferReader.close();

    }

//    public static ArrayList<Integer> grayCode(int velkostN, int pozicia) {
//        if (velkostN == 0) {
//            ArrayList<Integer> zoznam = new ArrayList<Integer>();
//            zoznam.add(0);
//            return zoznam;
//        }
//
//
//        ArrayList<Integer> zoznam = grayCode(velkostN - 1, pozicia);
//        int gcCisloNaPridanie = 1 << (velkostN - 1);
//        //System.out.println(gcCisloNaPridanie);
//        if (zoznam.size() - 1 >= pozicia) {
//            return zoznam;
//        }
//        for (int k = zoznam.size() - 1; k >= 0; k--) {
//            //System.out.println(gcCisloNaPridanie + zoznam.get(k));
//            zoznam.add(gcCisloNaPridanie + zoznam.get(k));
//            if (zoznam.size() - 1 >= pozicia) {
//                return zoznam;
//            }
//        }
//
//
//
//        return zoznam;
//    }

    public static int gray(int n) {
        //n--; <-- chyba
        return n ^ (n >> 1);
    }
}