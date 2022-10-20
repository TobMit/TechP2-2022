package Semester_1.Sutaz_2;

import java.util.Scanner;

public class Main_IPV4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pocet = scanner.nextLine();
        for (int i = 0; i < Integer.parseInt(pocet);i++){
            //int input = scanner.nextInt();
            String input = scanner.nextLine();
            String prvyO = input.substring(0, 8);
            String druhyO = input.substring(8, 16);
            String tretiO = input.substring(16, 24);
            String stvrtyO = input.substring(24);

            System.out.println(Integer.parseInt(prvyO, 2) + "." + Integer.parseInt(druhyO, 2) + "." + Integer.parseInt(tretiO, 2) + "." + Integer.parseInt(stvrtyO, 2));

        }
    }
}
