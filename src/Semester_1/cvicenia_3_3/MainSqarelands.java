package Semester_1.cvicenia_3_3;

import java.util.Scanner;

public class MainSqarelands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int vystup = 0;
            int medzihodnota = 0;
            int input = scanner.nextInt();
            //System.out.println(Math.sqrt(input));
            if ((Math.sqrt(input) - Math.round(Math.sqrt(input)) == 0)) {
                vystup = (int) Math.sqrt(input);
                System.out.println(vystup*4);
                continue;
            }
            //System.out.println(Math.round(Math.sqrt(input)));
            medzihodnota = input;
            while (true) {
                medzihodnota = ((int) Math.floor(Math.sqrt(input)));
                //System.out.println("1. " + medzihodnota);
                vystup += medzihodnota * 4;
                //System.out.println("2. " + vystup);
                //medzihodnota = input - medzihodnota * medzihodnota;
                //System.out.println("3. " + medzihodnota);
                input -= medzihodnota * medzihodnota;
                //System.out.println("4. " + input);
                if (input == 0) {
                    break;
                }
                //break;
            }
            //input = input * input * input;
            System.out.println(vystup);

        }
    }
}