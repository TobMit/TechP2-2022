package Semester_1.Sutaz;

import java.util.Scanner;

public class MainCensura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int pocetOpakovani = Integer.parseInt(scanner.nextLine());
        int pocetOpakovani = scanner.nextInt();
        System.out.println();
        //for (int i = 0; i < pocetOpakovani; i++) {
        while (scanner.hasNext()) {
            //int pocetRiatkov = Integer.parseInt(scanner.nextLine());
            int pocetRiatkov = scanner.nextInt();
            scanner.nextLine();
            String censura = scanner.nextLine();
            for (int j = 0; j < pocetRiatkov; j++) {
                String nacitanie = scanner.nextLine();
                String nacitanie1 = nacitanie.replace(censura, "");
                String nacitanie2 = nacitanie1.replace(censura, "");
                String nacitanie3 = nacitanie2.replace(censura, "");
                String nacitanie4 = nacitanie3.replace(censura, "");
                String nacitanie5 = nacitanie4.replace(censura, "");
                String nacitanie6 = nacitanie5.replace(censura, "");
                String nacitanie7 = nacitanie6.replace(censura, "");
                String nacitanie8 = nacitanie7.replace(censura, "");
                String nacitanie9 = nacitanie8.replace(censura, "");
                String nacitanie10 = nacitanie9.replace(censura, "");
                System.out.println(nacitanie10.replace(censura, ""));
            }
        }
    }
}
