package Semester_1.Sutaz;

import java.util.Scanner;

public class MainPrevodCiselCorrect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int roky = 0;
            int dni = 0;
            int hodina = 0;
            int minuty = 0;
            int sekundy = 0;
            int mms = 0;


            long input = scanner.nextLong();
            if (input == 0) {
                System.out.printf("%1dy,%01dd|%02dh:%02dm:%02ds.%03dms\n", 0, 0, 0, 0, 0, 0);
                continue;
            }
            //System.out.println("tu som");
            //System.out.println(input);

            roky = (int)Math.floor(((((input/ 1000)/ 60)/ 60)/ 24)/ 365);
            if (roky > 0) {
                input -= roky * 31536000000L;
            }
            //System.out.println(input);
            dni = (int)Math.floor((((input/ 1000)/ 60)/ 60)/ 24);
            if (dni > 0) {
                input -= dni * 86400000L;
            }
            //System.out.println(input);
            hodina = (int)Math.floor(((input/ 1000)/ 60)/ 60);
            if (hodina > 0) {
                input -= hodina * 3600000L;
            }
            //System.out.println(input);
            minuty = (int)Math.floor((input/ 1000)/ 60);
            if (minuty > 0) {
                input -= minuty * 60000L;
            }
            //System.out.println(input);
            sekundy = (int)Math.floor(input/ 1000);
            if (sekundy > 0) {
                input -= sekundy * 1000L;
            }
            //System.out.println(input);
            if (input < 0) {
                input = 0;
            }
            System.out.printf("%1dy,%01dd|%02dh:%02dm:%02ds.%03dms\n", roky, dni, hodina, minuty, sekundy, input);

        }
    }
}
