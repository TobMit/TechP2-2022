package Semester_1.testové.OdGlombika;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.math.BigInteger;
class MainGlombikJuggling {
    public static void main(String [] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("src/testCase.txt"));


        while (scanner.hasNextLine()) {
            ArrayList<String> pole = new ArrayList<>();
            StringTokenizer retazec = new StringTokenizer(scanner.nextLine(), " ");

            while (retazec.hasMoreTokens()) {
                pole.add(retazec.nextToken());
            }
            System.out.println(vypis(pole));
        }
    }

    public static String vypis(ArrayList<String> pole) {
        BigInteger number2 = new BigInteger("6");
        BigInteger number = new BigInteger(pole.get(3));



        int cislo2 = number.mod(number2).intValue();

        if (cislo2 == 0) {

            return pole.get(0) + " " + pole.get(1) + " " + pole.get(2);

        } else {


            switch (cislo2) {
                case 1:
                    return pole.get(1) + " " + pole.get(0) + " " + pole.get(2);
                case 2:
                    return pole.get(1) + " " + pole.get(2) + " " + pole.get(0);
                case 3:
                    return pole.get(2) + " " + pole.get(1) + " " + pole.get(0);
                case 4:
                    return pole.get(2) + " " + pole.get(0) + " " + pole.get(1);
                case 5:
                    return pole.get(0) + " " + pole.get(2) + " " + pole.get(1);


            }

        }
        return "";
    }
}
