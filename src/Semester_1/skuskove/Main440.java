package Semester_1.skuskove;

import java.util.Scanner;

public class Main440 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            for (int i = 2; ; i++) {
                int pocetMiest = input - 1;
                int pozicia = (i - 1) % pocetMiest;
                boolean test = true;
                while (pocetMiest > 1) {
                    if (pozicia == 0) {
                        test = false;
                        break;
                    }
                    pocetMiest--;
                    pozicia = (pozicia + i - 1) % pocetMiest;
                }
                if (test) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}

