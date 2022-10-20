package Semester_1.cvicenia_10_3;

import java.util.Scanner;

public class MainHugeFibonaci {
    private static int[] fibonacihoPostupnost = new int[1000000 + 1];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nuberOfTestCase = scanner.nextInt();
        //fibonacihoPostupnost = new int[1000000 + 1];
        MainHugeFibonaci.generujFibonacihoPostupnost();

        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            if (input == 0) {
                System.out.printf("%06d\n", input);
                continue;
            }

            System.out.printf("%06d\n", fibonacihoPostupnost[input] % 1000000);
            //System.out.printf("%06d\n", Semester_1.cvicenia_10_3.Semester_1.Sutaz_2.sorting.vratNFunkcia(input) % 1000000);

        }
    }

    private static void generujFibonacihoPostupnost() {
        fibonacihoPostupnost[0] = 0;
        // System.out.println(fibonacihoPostupnost[0]);
        fibonacihoPostupnost[1] = 1;
        //System.out.println(fibonacihoPostupnost[1]);
        for (int n = 2; n <= fibonacihoPostupnost.length - 1; n++) {
            fibonacihoPostupnost[n] = (fibonacihoPostupnost[n - 1] % 1000000) + (fibonacihoPostupnost[n - 2] % 1000000);
            //System.out.println(fibonacihoPostupnost[n]);
        }
    }

    private static int vratNFunkcia(int input) {
        //System.out.println(((1 / Math.sqrt(5)) * (  (Math.pow( (1 + Math.sqrt(5)) / 2, input) ) - (Math.pow( (1 - Math.sqrt(5)) / 2, input) ) ) ) );
        System.out.println(Math.floor ((1 / Math.sqrt(5)) * (  (Math.pow( (1 + Math.sqrt(5)) / 2, input) ) - (Math.pow( (1 - Math.sqrt(5)) / 2, input) ) ) ));
        return (int)Math.floor ((1 / Math.sqrt(5)) * (  (Math.pow( (1 + Math.sqrt(5)) / 2, input) ) - (Math.pow( (1 - Math.sqrt(5)) / 2, input) ) ) ) % 1000000;
        //(Math.pow((1 + Math.sqrt(5)), input) - Math.pow((1 - Math.sqrt(5)), input)) / Math.pow(2,) ;



    }

    private static int vratN(int input) {
        //int[] fibonacihoPostupnost = new int[input + 1];
        fibonacihoPostupnost[0] = 0;
       // System.out.println(fibonacihoPostupnost[0]);
        fibonacihoPostupnost[1] = 1;
        //System.out.println(fibonacihoPostupnost[1]);
        for (int n = 2; n <= input; n++) {
            fibonacihoPostupnost[n] = (fibonacihoPostupnost[n - 1] % 1000000) + (fibonacihoPostupnost[n - 2] % 1000000);
            //System.out.println(fibonacihoPostupnost[n]);
        }

        return fibonacihoPostupnost[input];
    }
}
