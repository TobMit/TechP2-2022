package Semester_1.Sutaz_2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class MainListEq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pocet = scanner.nextLine();
        for (int i = 0; i < Integer.parseInt(pocet); i++) {
            int prvyRiadok = scanner.nextInt();
            int druhyRiadok = scanner.nextInt();

            TreeMap<Integer, Integer> prvyRad = new TreeMap<>();
            TreeMap<Integer, Integer> druhyRad = new TreeMap<>();

//            int[] prvy = new int[prvyRiadok];
//            int[] druhy = new int[druhyRiadok];
            for (int j = 0; j < prvyRiadok; j++) {
                int cislo = scanner.nextInt();
                if (prvyRad.containsKey(cislo)) {
                    prvyRad.put(cislo, prvyRad.get(cislo) + 1);

                } else {
                    prvyRad.put(cislo, 1);
                }
            }
            scanner.nextLine();
            for (int j = 0; j < druhyRiadok; j++) {
                int cislo = scanner.nextInt();
                if (druhyRad.containsKey(cislo)) {
                    druhyRad.put(cislo, druhyRad.get(cislo) + 1);

                } else {
                    druhyRad.put(cislo, 1);
                }
            }

            if (i < Integer.parseInt(pocet) - 1) {
                scanner.nextLine();
            }

//            for (Integer cislo : prvyRad.keySet()) {
//                System.out.println(cislo + " " + prvyRad.get(cislo));
//            }
//            System.out.println();
//            for (Integer cislo : druhyRad.keySet()) {
//                System.out.println(cislo + " " + druhyRad.get(cislo));
//            }

//            for (int j = 0; j < prvy.length; j++) {
//                int pocetOpakovani = 0;
//                if (prvyRad.containsKey(prvy[j])) {
//                    continue;
//                }
//
//                for (int k = j; k < prvy.length; k++) {
//                    if (prvy[j] == prvy[k]) {
//                        pocetOpakovani++;
//                    }
//                }
//                prvyRad.put(prvy[j], pocetOpakovani);
//            }
//
//            for (int j = 0; j < druhy.length; j++) {
//                int pocetOpakovani = 0;
//                if (druhyRad.containsKey(druhy[j])) {
//                    continue;
//                }
//
//                for (int k = j; k < druhy.length; k++) {
//                    if (druhy[j] == druhy[k]) {
//                        pocetOpakovani++;
//                    }
//                }
//                druhyRad.put(druhy[j], pocetOpakovani);
//            }
            int pocetKrokov = 0;
            ArrayList<Integer> znakyNaZmazanie = new ArrayList<>();
            for (Integer znak : prvyRad.keySet()) {
                if (druhyRad.containsKey(znak)) {
                    continue;
                }
                znakyNaZmazanie.add(znak);
                pocetKrokov += prvyRad.get(znak);
            }

            for (Integer znak : druhyRad.keySet()) {
                if (prvyRad.containsKey(znak)) {
                    continue;
                }
                znakyNaZmazanie.add(znak);
                pocetKrokov += druhyRad.get(znak);
            }

            for (Integer zmaz : znakyNaZmazanie) {
                prvyRad.remove(zmaz);
                druhyRad.remove(zmaz);
            }

//            for (Integer integer : prvyRad.keySet()) {
//                System.out.println(integer + " " + prvyRad.get(integer));
//            }
//            System.out.println();
//            for (Integer integer : druhyRad.keySet()) {
//                System.out.println(integer + " " + druhyRad.get(integer));
//            }

            for (Integer cislo : prvyRad.keySet()) {
                if (prvyRad.get(cislo) != druhyRad.get(cislo)) {
                    if (prvyRad.get(cislo) > druhyRad.get(cislo)) {
                        pocetKrokov += prvyRad.get(cislo) - druhyRad.get(cislo);
                    } else {
                        pocetKrokov += druhyRad.get(cislo) - prvyRad.get(cislo);
                    }
                }
            }
            System.out.println(pocetKrokov);
        }
    }
}