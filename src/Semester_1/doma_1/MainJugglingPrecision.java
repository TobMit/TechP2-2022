package Semester_1.doma_1;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainJugglingPrecision {
    public static void main(String[] args) {
    //public static void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(new FileInputStream("src/testCase.txt"));
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();
        while (scanner.hasNext()) {
            input.add(scanner.nextLine());
        }
        for (String strings : input) {
            StringTokenizer rozdelovanie = new StringTokenizer(strings, " ");
            ArrayList<String> rozdeleneStrings = new ArrayList<>();
            while (rozdelovanie.hasMoreTokens()) {
                String vkladane = rozdelovanie.nextToken();
                //System.out.println(vkladane);
                rozdeleneStrings.add(vkladane);
            }
            System.out.println(rozklad(rozdeleneStrings));
        }
    }

    private static String rozklad(ArrayList<String> rozdeleneStrings) {
        long poradie = Long.parseLong(rozdeleneStrings.get(3));
        poradie = poradie % 6;
        if (poradie == 0) {
            return rozdeleneStrings.get(0) + " " + rozdeleneStrings.get(1) + " " + rozdeleneStrings.get(2);

        }
        //System.out.printf("poradie: " + poradie % 6);
        switch ((int)poradie) {
            case 1:
                return rozdeleneStrings.get(1) + " " + rozdeleneStrings.get(0) + " " + rozdeleneStrings.get(2);
            case 2:
                return rozdeleneStrings.get(1) + " " + rozdeleneStrings.get(2) + " " + rozdeleneStrings.get(0);
            case 3:
                return rozdeleneStrings.get(2) + " " + rozdeleneStrings.get(1) + " " + rozdeleneStrings.get(0);
            case 4:
                return rozdeleneStrings.get(2) + " " + rozdeleneStrings.get(0) + " " + rozdeleneStrings.get(1);
            case 5:
                return rozdeleneStrings.get(0) + " " + rozdeleneStrings.get(2) + " " + rozdeleneStrings.get(1);
        }
        return "";
    }

}