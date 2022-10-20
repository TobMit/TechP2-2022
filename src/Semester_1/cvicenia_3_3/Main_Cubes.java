package Semester_1.cvicenia_3_3;

import java.util.Scanner;

public class Main_Cubes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            if (input == 0) {
                return;
            }
            input = input * input * input;
            System.out.println(input);

        }
    }
}