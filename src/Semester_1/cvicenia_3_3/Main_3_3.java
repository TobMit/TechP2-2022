package Semester_1.cvicenia_3_3;

import java.util.Scanner;

public class Main_3_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();

            System.out.println(input + 1);

        }
    }
}